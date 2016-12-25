package io.egen.movieflix.service.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.movieflix.entity.Account;
import io.egen.movieflix.exceptions.UserAlreadyExistsException;
import io.egen.movieflix.generic.respository.GenericRepositoryImpl;
import io.egen.movieflix.service.AccountService;
import io.egen.movieflix.utils.ApplicationLogger;
import io.egen.movieflix.utils.ApplicationConstants.ApplicationRoles;

@Service
public class AccountServiceImpl extends GenericRepositoryImpl<Account> implements AccountService {

	@Autowired
	ApplicationLogger log;
	
	public AccountServiceImpl() throws Exception {
		super();
	}

	@Override
	public Account lookUpAccount(String username, String password) throws Exception {
		TypedQuery<Account> query = em.createNamedQuery("Account.lookUpLogin", Account.class);
		query.setParameter("userName", username);
		query.setParameter("password", password);
		List<Account> accounts = query.getResultList();
		if (accounts != null && accounts.size() == 1) {
			return accounts.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> fetchAllUserAccount(String role) throws Exception {
		Query query = em.createQuery("Select a from Account a where a.accountRole.code.value = :role");
		query.setParameter("role", role);
		List<Account> accounts = query.getResultList();
		return accounts;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Account> fetchAccountByUserName(String userName) throws UserAlreadyExistsException {
		Query query = em
				.createQuery("select account from Account account where account.accountRole.code.value = :role and account.userName =:userName");
		query.setParameter("role", ApplicationRoles.USER.getRole());
		query.setParameter("userName", userName);
		return query.getResultList();
	}

}
