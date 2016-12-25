package io.egen.movieflix.controller;

import static io.egen.movieflix.utils.ApplicationConstants.PAGINATION_SIZE;
import static io.egen.movieflix.utils.ApplicationConstants.SESSION_USER_OBJECT;

import java.util.ArrayList;
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

import io.egen.movieflix.DTO.AccountDTO;
import io.egen.movieflix.DTO.TitleDTO;
import io.egen.movieflix.DTO.TitlePaginationDTO;
import io.egen.movieflix.entity.Account;
import io.egen.movieflix.entity.Title;
import io.egen.movieflix.service.impl.AccountServiceImpl;
import io.egen.movieflix.service.impl.TitleServiceImpl;
import io.egen.movieflix.service.impl.UserServiceImpl;
import io.egen.movieflix.utils.ApplicationLogger;
import io.egen.movieflix.utils.ApplicationUtils;
import io.egen.movieflix.utils.ConversionUtils;
import io.egen.movieflix.validators.TitleValidator;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	AccountServiceImpl accountService;

	@Autowired
	TitleServiceImpl titleService;

	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	TitleValidator titleValidator;

	@Autowired
	ApplicationLogger log;

	@Autowired
	ApplicationUtils applicationUtils;

	@Autowired
	ConversionUtils conversionUtils;

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AccountDTO> fetchAllUsers() {
		try {
			List<Account> accounts = userService.fetchAllUsers();
			List<AccountDTO> accountDTO = new ArrayList<>();
			if(accounts != null && !accounts.isEmpty()){
				for(Account account : accounts){
					accountDTO.add(conversionUtils.convertAccountEntityToDTO(account));
				}
			}
			return accountDTO;
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
			Integer searchCount = titleService.findTotalCustomizedSearchTitleCount(typeId, year, genre, title,
					topRated);
			int fetchCount = (fromIndex + PAGINATION_SIZE) > searchCount ? (searchCount - fromIndex) : PAGINATION_SIZE;
			List<Title> newTitleList = titleService.fetchAllTitle(fromIndex, fetchCount);
			List<TitleDTO> titleResult = new ArrayList<>();
			if(newTitleList != null && !newTitleList.isEmpty()){
				for(Title entity : newTitleList){
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

	@RequestMapping(value = "/saveTitle", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.ALL_VALUE)
	public TitleDTO saveTitle(@RequestBody TitleDTO titleDTO, HttpServletRequest request) {
		try {
			if(titleValidator.checkTitleValidity(titleDTO)){
				HttpSession session = request.getSession();
				Account account = (Account) session.getAttribute(SESSION_USER_OBJECT);
				Title title = conversionUtils.getTitleEntity(titleDTO, account);
				if (title.getTitleIdPk() == null) {
					titleService.create(title);
				} else {
					titleService.update(title);
				}
				TitleDTO dto = conversionUtils.getTitleDTO(title);
				return dto;
			}
			return null;//TODO replace with appropriate error message
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@RequestMapping(value = "/title/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteTitle(@PathVariable("id") String id) {
		try {
			titleService.delete(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
