package io.egen.movieflix.DTO;

import lombok.Data;

@Data
public class UserTitleRatingDTO {
	private String userTitleRatingId;
	private AccountDTO accountDTO;
	private String userTitleRating;
	private String titleId;	
}
