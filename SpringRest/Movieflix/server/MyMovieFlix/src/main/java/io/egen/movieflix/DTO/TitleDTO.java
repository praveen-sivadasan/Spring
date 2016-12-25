package io.egen.movieflix.DTO;

import java.util.List;
import lombok.Data;

@Data
public class TitleDTO {
	private String titleIdPk;
	private String actors;
	private String awards;
	private String createDate;
	private String director;
	private String imdbId;
	private String imdbRating;
	private String imdbVotes;
	private String metascore;
	private String userRating;
	private String plot;
	private String poster;
	private String releaseDate;
	private String runtime;
	private String title;
	private String writer;
	private String year;
	private String deleteFlag;
	private CodeMasterDTO titleTypeDTO;
	private CodeMasterDTO titleRatingDTO;
	private List<TitleCountryDTO> titleCountries;
	private List<TitleGenreDTO> titleGenres;
	private List<TitleLanguageDTO> titleLanguages;
	private List<UserTitleCommentDTO> titleComments;
	
	private UserTitleRatingDTO userTitleRatingDTO;//for a specific user
}
