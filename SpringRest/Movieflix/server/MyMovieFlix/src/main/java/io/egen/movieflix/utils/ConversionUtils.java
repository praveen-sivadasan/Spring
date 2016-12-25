package io.egen.movieflix.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.movieflix.DTO.AccountDTO;
import io.egen.movieflix.DTO.CodeDTO;
import io.egen.movieflix.DTO.CodeMasterDTO;
import io.egen.movieflix.DTO.TitleCountryDTO;
import io.egen.movieflix.DTO.TitleDTO;
import io.egen.movieflix.DTO.TitleGenreDTO;
import io.egen.movieflix.DTO.TitleLanguageDTO;
import io.egen.movieflix.DTO.UserDetailDTO;
import io.egen.movieflix.DTO.UserTitleCommentDTO;
import io.egen.movieflix.DTO.UserTitleRatingDTO;
import io.egen.movieflix.entity.Account;
import io.egen.movieflix.entity.Code;
import io.egen.movieflix.entity.CodeMaster;
import io.egen.movieflix.entity.Title;
import io.egen.movieflix.entity.TitleCountry;
import io.egen.movieflix.entity.TitleGenre;
import io.egen.movieflix.entity.TitleLanguage;
import io.egen.movieflix.entity.UserDetail;
import io.egen.movieflix.entity.UserTitleComment;
import io.egen.movieflix.entity.UserTitleRating;

@Service
public class ConversionUtils {

	@Autowired
	ApplicationUtils utils;

	public TitleDTO getTitleDTO(Title title) throws Exception {
		TitleDTO dto = convertTitleEntityToDTO(title);

		List<TitleCountryDTO> countries = convertTitleCountryEntitiesToDTOs(title.getTitleCountries());
		List<TitleGenreDTO> genres = convertTitleGenreEntitiesToDTOs(title.getTitleGenres());
		List<TitleLanguageDTO> languages = convertTitleLangEntitiesToDTOs(title.getTitleLanguages());
		List<UserTitleCommentDTO> comments = convertUserTitleCommentEntitiesToDTOs(title.getUserComments());

		dto.setTitleCountries(countries);
		dto.setTitleGenres(genres);
		dto.setTitleLanguages(languages);
		dto.setTitleComments(comments);

		return dto;
	}

	public Title getTitleEntity(TitleDTO titleDTO, Account account) throws Exception {
		Title title = convertTitleDTOToEntity(titleDTO);

		List<TitleCountry> countries = convertTitleCountryDTOsToEntities(titleDTO.getTitleCountries(), title);
		List<TitleGenre> genres = convertTitleGenreDTOsToEntities(titleDTO.getTitleGenres(), title);
		List<TitleLanguage> languages = convertTitleLangDTOsToEntities(titleDTO.getTitleLanguages(), title);
		List<UserTitleComment> comments = convertUserTitleCommentsDTOToEntities(titleDTO.getTitleComments(), title,
				account);

		title.setTitleCountries(countries);
		title.setTitleGenres(genres);
		title.setTitleLanguages(languages);
		title.setUserComments(comments);

		return title;
	}

	public TitleDTO convertTitleEntityToDTO(Title title) {
		TitleDTO dto = new TitleDTO();
		dto.setTitleIdPk(title.getTitleIdPk() != null ? (String.valueOf(title.getTitleIdPk())) : null);
		dto.setActors(title.getActors() != null ? title.getActors() : null);
		dto.setAwards(title.getAwards() != null ? title.getAwards() : null);
		dto.setCreateDate(title.getCreateDate().toString());
		dto.setDirector(title.getDirector() != null ? title.getDirector() : null);
		dto.setImdbId(title.getImdbId() != null ? title.getImdbId() : null);
		dto.setImdbRating(title.getImdbRating() != null ? String.valueOf(title.getImdbRating()) : null);
		dto.setImdbVotes(title.getImdbVotes() != null ? title.getImdbVotes() : null);
		dto.setMetascore(title.getMetascore() != null ? title.getMetascore() : null);
		dto.setUserRating(title.getUserRating() != null ? String.valueOf(title.getUserRating()) : null);
		dto.setPlot(title.getPlot() != null ? title.getPlot() : null);
		dto.setPoster(title.getPoster() != null ? title.getPoster() : null);
		dto.setReleaseDate(title.getReleaseDate() != null ? title.getReleaseDate().toString() : null);
		dto.setRuntime(title.getRuntime());
		dto.setTitle(title.getTitle());
		dto.setWriter(title.getWriter());
		dto.setYear(title.getYear());
		dto.setDeleteFlag(title.getDeleteFlag() != null ? String.valueOf(title.getDeleteFlag()) : null);
		dto.setTitleTypeDTO(convertCodeMasterEntityToDTO(title.getTitleType()));
		dto.setTitleRatingDTO(convertCodeMasterEntityToDTO(title.getTitleRating()));

		return dto;
	}

	public Title convertTitleDTOToEntity(TitleDTO dto) throws Exception {
		Title title = new Title();
		title.setTitleIdPk(dto.getTitleIdPk() != null ? (Integer.valueOf(title.getTitleIdPk())) : null);
		title.setActors(dto.getActors() != null ? title.getActors() : null);
		title.setAwards(dto.getAwards() != null ? title.getAwards() : null);
		title.setDirector(dto.getDirector());
		title.setImdbId(dto.getImdbId());
		title.setImdbRating(dto.getImdbRating() != null ? Integer.valueOf(dto.getImdbRating()) : null);
		title.setImdbVotes(dto.getImdbVotes() != null ? title.getImdbVotes() : null);
		title.setMetascore(dto.getMetascore() != null ? title.getMetascore() : null);
		title.setUserRating((dto.getUserRating() != null && !dto.getUserRating().trim().equals(""))
				? Float.valueOf(title.getUserRating()) : null);
		title.setPlot(dto.getPlot());
		title.setPoster(dto.getPoster());
		title.setReleaseDate(utils.convertStringToDate(dto.getReleaseDate()));
		title.setRuntime(dto.getRuntime());
		title.setTitle(dto.getTitle());
		title.setWriter(dto.getWriter());
		title.setYear(title.getYear());
		title.setDeleteFlag(dto.getDeleteFlag() != null ? Integer.valueOf(dto.getDeleteFlag()) : null);

		// One to one mappings
		title.setTitleType(dto.getTitleTypeDTO() != null ? convertCodeMasterDTOToEntity(dto.getTitleTypeDTO()) : null);
		title.setTitleRating(
				dto.getTitleRatingDTO() != null ? convertCodeMasterDTOToEntity(dto.getTitleRatingDTO()) : null);

		return title;
	}

	// TITLE_LANGUAGE
	public List<TitleLanguageDTO> convertTitleLangEntitiesToDTOs(List<TitleLanguage> languages) {
		List<TitleLanguageDTO> dtos = null;
		if (languages != null) {
			dtos = new ArrayList<>();
			for (TitleLanguage language : languages) {
				TitleLanguageDTO dto = new TitleLanguageDTO();
				dto.setLanguage(
						language.getLanguage() != null ? convertCodeMasterEntityToDTO(language.getLanguage()) : null);
				dto.setTitleLanguageId(language.getTitleLanguageIdPk() != null
						? String.valueOf(language.getTitleLanguageIdPk()) : null);
				dtos.add(dto);
			}
		}
		return dtos;
	}

	public List<TitleLanguage> convertTitleLangDTOsToEntities(List<TitleLanguageDTO> dtos, Title title) {
		List<TitleLanguage> languages = null;
		if (dtos != null) {
			languages = new ArrayList<>();
			for (TitleLanguageDTO dto : dtos) {
				TitleLanguage entity = new TitleLanguage();
				entity.setLanguage(dto.getLanguage() != null ? convertCodeMasterDTOToEntity(dto.getLanguage()) : null);
				entity.setTitleLanguageIdPk(
						dto.getTitleLanguageId() != null ? Integer.valueOf(dto.getTitleLanguageId()) : null);
				entity.setTitle(title);
				languages.add(entity);
			}
		}
		return languages;
	}

	// TITLE_GENRE
	public List<TitleGenreDTO> convertTitleGenreEntitiesToDTOs(List<TitleGenre> genres) {
		List<TitleGenreDTO> genreDTOs = null;
		if (genres != null) {
			genreDTOs = new ArrayList<>();
			for (TitleGenre genre : genres) {
				TitleGenreDTO dto = new TitleGenreDTO();
				dto.setGenre(genre.getGenre() != null ? convertCodeMasterEntityToDTO(genre.getGenre()) : null);
				dto.setTitleGenreId(
						genre.getTitleGenreIdPk() != null ? String.valueOf(genre.getTitleGenreIdPk()) : null);
				genreDTOs.add(dto);
			}
		}
		return genreDTOs;
	}

	public List<TitleGenre> convertTitleGenreDTOsToEntities(List<TitleGenreDTO> dtos, Title title) {
		List<TitleGenre> genres = null;
		if (dtos != null) {
			genres = new ArrayList<>();
			for (TitleGenreDTO genreDTO : dtos) {
				TitleGenre entity = new TitleGenre();
				entity.setGenre(genreDTO.getGenre() != null ? convertCodeMasterDTOToEntity(genreDTO.getGenre()) : null);
				entity.setTitleGenreIdPk(
						genreDTO.getTitleGenreId() != null ? Integer.valueOf(genreDTO.getTitleGenreId()) : null);
				entity.setTitle(title);
				genres.add(entity);
			}
		}
		return genres;
	}

	// TITLE_COUNTRY
	public List<TitleCountryDTO> convertTitleCountryEntitiesToDTOs(List<TitleCountry> countries) {
		List<TitleCountryDTO> countryDTOs = null;
		if (countries != null) {
			countryDTOs = new ArrayList<>();
			for (TitleCountry country : countries) {
				TitleCountryDTO dto = new TitleCountryDTO();
				dto.setCountry(
						country.getCountry() != null ? convertCodeMasterEntityToDTO(country.getCountry()) : null);
				dto.setTitleCountryId(
						country.getTitleCountryIdPk() != null ? String.valueOf(country.getTitleCountryIdPk()) : null);
				countryDTOs.add(dto);
			}
		}
		return countryDTOs;
	}

	public List<TitleCountry> convertTitleCountryDTOsToEntities(List<TitleCountryDTO> dtos, Title title) {
		List<TitleCountry> countries = null;
		if (dtos != null) {
			countries = new ArrayList<>();
			for (TitleCountryDTO countryDTO : dtos) {
				TitleCountry entity = new TitleCountry();
				entity.setCountry(
						countryDTO.getCountry() != null ? convertCodeMasterDTOToEntity(countryDTO.getCountry()) : null);
				entity.setTitleCountryIdPk(countryDTO.getTitleCountryId() != null
						? Integer.valueOf(countryDTO.getTitleCountryId()) : null);
				entity.setTitle(title);
				countries.add(entity);
			}
		}
		return countries;
	}

	// USER_TITLE_RATING
	public UserTitleRatingDTO convertUserTitleRatingEntityToDTO(UserTitleRating entity) {
		UserTitleRatingDTO dto = new UserTitleRatingDTO();
		//skip storing title and account in dto
		if(entity != null){
			dto.setUserTitleRating(entity.getRating() != null ? entity.getRating().toString() : null);
			dto.setUserTitleRatingId(
					entity.getUserTitleRatingIdPk() != null ? String.valueOf(entity.getUserTitleRatingIdPk()) : null);
		}
		return dto;
	}

	public UserTitleRating convertUserTitleRatingDTOToEntity(UserTitleRatingDTO dto) {
		UserTitleRating entity = new UserTitleRating();
		entity.setUserTitleRatingIdPk(
				dto.getUserTitleRatingId() != null ? Integer.valueOf(dto.getUserTitleRatingId()) : null);
		entity.setRating(dto.getUserTitleRating() != null ? Integer.valueOf(dto.getUserTitleRating()) : null);

		return entity;
	}
	
	
	// USER_TITLE_COMMENT
	public List<UserTitleCommentDTO> convertUserTitleCommentEntitiesToDTOs(List<UserTitleComment> comments)
			throws Exception {
		List<UserTitleCommentDTO> dtos = null;
		if (comments != null) {
			dtos = new ArrayList<>();
			for (UserTitleComment comment : comments) {
				UserTitleCommentDTO dto = new UserTitleCommentDTO();
				dto.setAccount(convertAccountEntityToDTO(comment.getAccount()));
				dto.setComment(comment.getComment());
				dto.setUserTitleCommentId(comment.getUserTitleCommentIdPk() != null
						? String.valueOf(comment.getUserTitleCommentIdPk()) : null);
				dtos.add(dto);
			}
		}
		return dtos;
	}

	public List<UserTitleComment> convertUserTitleCommentsDTOToEntities(List<UserTitleCommentDTO> dtos, Title title,
			Account account) throws Exception {
		List<UserTitleComment> comments = null;
		if (dtos != null) {
			comments = new ArrayList<>();
			for (UserTitleCommentDTO dto : dtos) {
				UserTitleComment entity = new UserTitleComment();
				entity.setAccount(convertAccountDTOToEntity(dto.getAccount()));
				entity.setComment(
						(dto.getComment() != null && dto.getComment().trim().equals("")) ? dto.getComment() : null);
				entity.setUserTitleCommentIdPk(
						dto.getUserTitleCommentId() != null ? Integer.valueOf(dto.getUserTitleCommentId()) : null);
				entity.setCreateDate(new Date());
				entity.setTitle(title);
				comments.add(entity);
			}
		}
		return comments;
	}

	// USER DETAIL
	public UserDetailDTO convertUserDetailEntityToDTO(UserDetail userDetail) {
		UserDetailDTO dto = new UserDetailDTO();
		dto.setAddress(userDetail.getAddress());
		dto.setPhoneNumber(userDetail.getPhoneNumber());
		dto.setUserDetailsIdPk(
				userDetail.getUserDetailsIdPk() != null ? String.valueOf(userDetail.getUserDetailsIdPk()) : null);
		return dto;
	}

	public UserDetail convertUserDetailDTOToEntity(UserDetailDTO userDetailDTO) {
		UserDetail userDetail = new UserDetail();
		userDetail.setAddress(userDetailDTO.getAddress());
		userDetail.setPhoneNumber(userDetailDTO.getPhoneNumber());
		userDetail.setUserDetailsIdPk(userDetailDTO.getUserDetailsIdPk() != null
				? Integer.valueOf(userDetailDTO.getUserDetailsIdPk()) : null);
		return userDetail;
	}

	// ACCOUNT
	public AccountDTO convertAccountEntityToDTO(Account entity) throws Exception {

		AccountDTO dto = new AccountDTO();
		dto.setAccountId(entity.getAccountIdPk() != null ? String.valueOf(entity.getAccountIdPk()) : null);
		dto.setRole(convertCodeMasterEntityToDTO(entity.getAccountRole()));
		dto.setCreateDate(utils.convertDateToString(entity.getCreateDate()));
		dto.setEmail(entity.getEmail());
		dto.setFirstName(entity.getFirstName());
		dto.setGender(convertCodeMasterEntityToDTO(entity.getGender()));
		dto.setLastName(entity.getLastName());
		dto.setPassword(entity.getPassword());
		dto.setUserName(entity.getUserName());
		dto.setUserDetailDTO(
				entity.getUserDetail() != null ? convertUserDetailEntityToDTO(entity.getUserDetail()) : null);

		return dto;
	}

	public Account convertAccountDTOToEntity(AccountDTO dto) throws Exception {
		Account entity = new Account();
		entity.setAccountIdPk(dto.getAccountId() != null ? Integer.valueOf(dto.getAccountId()) : null);
		entity.setAccountRole(convertCodeMasterDTOToEntity(dto.getRole()));
		entity.setCreateDate(utils.convertStringToDate(dto.getCreateDate()));
		entity.setEmail(entity.getEmail());
		entity.setFirstName(entity.getFirstName());
		entity.setGender(convertCodeMasterDTOToEntity(dto.getGender()));
		entity.setLastName(entity.getLastName());
		entity.setPassword(entity.getPassword());
		entity.setUserName(entity.getUserName());
		entity.setUserDetail(
				dto.getUserDetailDTO() != null ? convertUserDetailDTOToEntity(dto.getUserDetailDTO()) : null);

		return entity;
	}

	// CODEMASTER
	public CodeMasterDTO convertCodeMasterEntityToDTO(CodeMaster entity) {
		CodeMasterDTO dto = new CodeMasterDTO();
		dto.setCodeMasterId(entity.getCodeMasterIdPk().toString());
		dto.setValue(entity.getValue());
		if (dto.getCode() != null) {
			dto.setCode(convertCodeEntityToDTO(entity.getCode()));
		}
		return dto;
	}

	public CodeMaster convertCodeMasterDTOToEntity(CodeMasterDTO dto) {
		CodeMaster entity = new CodeMaster();
		entity.setCodeMasterIdPk(dto.getCodeMasterId() != null ? Integer.parseInt(dto.getCodeMasterId()) : null);
		entity.setValue(dto.getValue());
		if (dto.getCode() != null) {
			entity.setCode(convertCodeDTOtoEntity(dto.getCode()));
		}
		return entity;
	}

	// CODE
	public Code convertCodeDTOtoEntity(CodeDTO dto) {
		Code code = new Code();
		code.setCodeIdPk(dto.getCodeId() != null ? Integer.parseInt(dto.getCodeId()) : null);
		code.setValue(dto.getValue());
		return code;
	}

	public CodeDTO convertCodeEntityToDTO(Code entity) {
		CodeDTO dto = new CodeDTO();
		dto.setCodeId(entity.getCodeIdPk().toString());
		dto.setValue(entity.getValue());
		return dto;
	}

}
