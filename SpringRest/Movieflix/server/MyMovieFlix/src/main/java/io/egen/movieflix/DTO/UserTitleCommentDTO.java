package io.egen.movieflix.DTO;

import lombok.Data;

@Data
public class UserTitleCommentDTO {
	private String userTitleCommentId;
	private String comment;
	private AccountDTO account;
	
}
