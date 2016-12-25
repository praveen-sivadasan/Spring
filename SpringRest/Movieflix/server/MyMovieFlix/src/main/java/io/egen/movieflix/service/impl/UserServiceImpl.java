package io.egen.movieflix.service.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.movieflix.entity.Account;
import io.egen.movieflix.entity.UserTitleComment;
import io.egen.movieflix.entity.UserTitleRating;
import io.egen.movieflix.generic.respository.GenericRepositoryImpl;
import io.egen.movieflix.service.UserService;
import static io.egen.movieflix.utils.ApplicationConstants.ApplicationRoles;
import io.egen.movieflix.utils.ApplicationLogger;

@Service
public class UserServiceImpl extends GenericRepositoryImpl<Account> implements UserService {

	@Autowired
	ApplicationLogger log;

	public UserServiceImpl() throws Exception {
		super();
	}

	@Override
	public UserTitleComment saveComment(UserTitleComment userTitleComment) throws Exception {
		if (userTitleComment.getUserTitleCommentIdPk() == null) {
			em.persist(userTitleComment);
		} else {
			em.merge(userTitleComment);
		}
		return userTitleComment;
	}

	@Override
	public UserTitleRating saveTitleRating(UserTitleRating userTitleRating) throws Exception {
		if (userTitleRating.getUserTitleRatingIdPk() == null) {
			em.persist(userTitleRating);
		} else {
			em.merge(userTitleRating);
		}
		return userTitleRating;

	}

	@Override
	public UserTitleRating fetchUserTitleRating(Integer accountId, Integer titleId) throws Exception {
		Query query = em.createQuery("select utr from UserTitleRating utr where utr.titleIdFk = :titleIdFk "
				+ "and utr.account.accountIdPk = :accountIdPk ");
		UserTitleRating utr = (UserTitleRating) query.getSingleResult();
		return utr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> fetchAllUsers() throws Exception {
		Query query = em
				.createQuery("select account from Account account where account.accountRole.code.value = :role ");
		query.setParameter("role", ApplicationRoles.USER.getRole());
		return query.getResultList();
	}
	
}
