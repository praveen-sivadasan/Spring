package io.egen.movieflix.DTO;

import lombok.Data;

@Data
public class UserTitleUpdateDTO {
	private String newUserComment;
	private TitleDTO title;
	private UserTitleRatingDTO userTitleRating;
}
