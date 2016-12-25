package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.entity.Account;
import io.egen.movieflix.exceptions.UserAlreadyExistsException;

public interface AccountService {
	public Account lookUpAccount(String username, String password) throws Exception;
	public List<Account> fetchAllUserAccount(String role) throws Exception;
	public List<Account> fetchAccountByUserName(String userName) throws UserAlreadyExistsException ;
}
