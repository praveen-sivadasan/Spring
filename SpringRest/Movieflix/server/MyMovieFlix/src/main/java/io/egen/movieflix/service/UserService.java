package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.entity.Account;
import io.egen.movieflix.entity.UserTitleComment;
import io.egen.movieflix.entity.UserTitleRating;

public interface UserService {
	public UserTitleComment saveComment(UserTitleComment userTitleComment) throws Exception;
	public UserTitleRating saveTitleRating(UserTitleRating userTitleRating) throws Exception;
	public UserTitleRating fetchUserTitleRating(Integer accountId, Integer titleId) throws Exception;
	public List<Account> fetchAllUsers()throws Exception;
}
