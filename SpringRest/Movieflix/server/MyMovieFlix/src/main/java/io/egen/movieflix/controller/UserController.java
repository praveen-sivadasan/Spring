package io.egen.movieflix.controller;

import static io.egen.movieflix.utils.ApplicationConstants.PAGINATION_SIZE;
import static io.egen.movieflix.utils.ApplicationConstants.SESSION_USER_OBJECT;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.DTO.TitleDTO;
import io.egen.movieflix.DTO.TitlePaginationDTO;
import io.egen.movieflix.DTO.UserTitleRatingDTO;
import io.egen.movieflix.DTO.UserTitleUpdateDTO;
import io.egen.movieflix.entity.Account;
import io.egen.movieflix.entity.Title;
import io.egen.movieflix.entity.UserTitleComment;
import io.egen.movieflix.entity.UserTitleRating;
import io.egen.movieflix.service.impl.TitleServiceImpl;
import io.egen.movieflix.service.impl.UserServiceImpl;
import io.egen.movieflix.utils.ApplicationLogger;
import io.egen.movieflix.utils.ApplicationUtils;
import io.egen.movieflix.utils.ConversionUtils;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	TitleServiceImpl titleservice;

	@Autowired
	UserServiceImpl userService;

	@Autowired
	ApplicationLogger log;

	@Autowired
	ApplicationUtils utils;

	@Autowired
	ConversionUtils conversionUtils;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Account findAll() {
		try {
			return userService.find(1);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Generic function to handle view catalog and infinite scrolling
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/catalog", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public TitlePaginationDTO findAllTitles(@RequestBody TitlePaginationDTO dto) {
		try {
			Integer fromIndex = dto.getFromIndex() != null ? (Integer.parseInt(dto.getFromIndex())) : 0;
			Integer typeId = dto.getTitleTypeId() != null ? (Integer.parseInt(dto.getTitleTypeId())) : 0;
			String year = (dto.getYear() != null || !dto.getYear().trim().equals("")) ? dto.getYear() : null;
			String genre = (dto.getGenre() != null || !dto.getGenre().trim().equals("")) ? dto.getGenre() : null;
			String title = (dto.getTitle() != null || !dto.getTitle().trim().equals("")) ? dto.getTitle() : null;
			Boolean topRated = (dto.isViewTopRated()) ? true : null;
			Integer searchCount = titleservice.findTotalCustomizedSearchTitleCount(typeId, year, genre, title,
					topRated);
			int fetchCount = (fromIndex + PAGINATION_SIZE) > searchCount ? (searchCount - fromIndex) : PAGINATION_SIZE;
			List<Title> newTitleList = titleservice.fetchAllTitle(fromIndex, fetchCount);
			List<TitleDTO> titleResult = new ArrayList<>();
			if (newTitleList != null && !newTitleList.isEmpty()) {
				for (Title entity : newTitleList) {
					titleResult.add(conversionUtils.getTitleDTO(entity));
				}
			}
			dto.setTitleList(titleResult);
			dto.setFromIndex(String.valueOf(fromIndex + fetchCount));
			return dto;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Fetch a title for user to comment, rate or view
	 * 
	 * @param titleId
	 * @return
	 */
	@RequestMapping(value = "/title/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserTitleUpdateDTO fetchTitleForViewing(@PathVariable("id") String titleId, HttpServletRequest request) {
		try {
			UserTitleUpdateDTO dto = new UserTitleUpdateDTO();
			HttpSession session = request.getSession();
			Account account = (Account) session.getAttribute(SESSION_USER_OBJECT);
			Title title = titleservice.find(Integer.valueOf(titleId));
			UserTitleRating rating = titleservice.fetchUserTitleRating(Integer.valueOf(titleId),
					account.getAccountIdPk());

			dto.setTitle(conversionUtils.convertTitleEntityToDTO(title));
			dto.setUserTitleRating(conversionUtils.convertUserTitleRatingEntityToDTO(rating));

			return dto;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Method to save title by user. User can comment and provide a rating.
	 * 
	 * @param titleId
	 * @param dto
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/reviewtitle/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserTitleUpdateDTO updateUserTitleReview(@PathVariable("id") String titleId,
			@RequestBody UserTitleUpdateDTO dto, HttpServletRequest request) {
		try {
			Title title = conversionUtils.convertTitleDTOToEntity(dto.getTitle());
			HttpSession session = request.getSession();
			Account sesionObject = (Account) session.getAttribute(SESSION_USER_OBJECT);

			if (dto.getNewUserComment() != null && !dto.getNewUserComment().trim().equals("")) {
				UserTitleComment comment = new UserTitleComment();
				comment.setCreateDate(new Date());
				comment.setComment(dto.getNewUserComment());
				comment.setTitle(title);
				comment.setAccount(null);
				userService.saveComment(comment);
			}
			UserTitleRatingDTO ratingDTO = dto.getUserTitleRating();
			UserTitleRating rating = new UserTitleRating();
			if (ratingDTO != null && ratingDTO.getUserTitleRating() != null) {
				rating = conversionUtils.convertUserTitleRatingDTOToEntity(ratingDTO);
				rating.setAccount(sesionObject);
				rating.setTitle(title);
				rating = userService.saveTitleRating(rating);
			}
			List<Object[]> averageRating = titleservice.fetchNewUserTitleAverage(title.getTitleIdPk());
			Float newAverageRating = 0F;
			if (averageRating != null && !averageRating.isEmpty()) {
				for (Object[] obj : averageRating) {
					newAverageRating = (Float) obj[1] / (Float) obj[0];
					break;
				}
			}
			title.setUserRating(newAverageRating);
			Title titleSaved = titleservice.update(title);

			dto.setNewUserComment(null);
			dto.setUserTitleRating(conversionUtils.convertUserTitleRatingEntityToDTO(rating));
			dto.setTitle(conversionUtils.convertTitleEntityToDTO(titleSaved));
			return dto;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

}
