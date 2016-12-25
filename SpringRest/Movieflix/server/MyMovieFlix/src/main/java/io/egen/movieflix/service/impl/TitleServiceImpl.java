package io.egen.movieflix.service.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.movieflix.entity.Title;
import io.egen.movieflix.entity.UserTitleRating;
import io.egen.movieflix.generic.respository.GenericRepositoryImpl;
import io.egen.movieflix.service.TitleService;
import io.egen.movieflix.utils.ApplicationLogger;

@Service
public class TitleServiceImpl extends GenericRepositoryImpl<Title> implements TitleService {

	@Autowired
	ApplicationLogger log;

	public TitleServiceImpl() throws Exception {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Title> fetchAllTitle(int fromTableIndex, int toTableIndex) throws Exception {
		Query query = em.createQuery("Select t from Title t where t.deleteFlag = 1 " + "order by t.createDate desc");
		query.setFirstResult(fromTableIndex);
		query.setMaxResults(toTableIndex - fromTableIndex);
		return (List<Title>) query.getResultList();
	}

	@Override
	public void delete(Object id) throws Exception {
		Query query = em.createQuery(" update table Title t set t.deleteFlag = 0 where t.titleIdPk = :titleIdPk ");
		query.setParameter("titleIdPk", id);
		query.executeUpdate();
	}

	@Override
	public int findTotalTitleCount() throws Exception {
		Query query = em.createQuery("Select count(*) from Title t where t.deleteFlag = 1");
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Title> fetchCustomizedSearchTitle(String typeId, String year, String genre, String title,
			Boolean topRated, int fromTableIndex, int fetchCount) throws Exception {
		StringBuffer queryString = new StringBuffer("Select t from Title t");
		String queryWhere = " where t.deleteFlag = 1 ";
		StringBuffer criterias = new StringBuffer(queryWhere);
		if (typeId != null && !typeId.equalsIgnoreCase("")) {
			criterias.append(" t.titleType.codeMasterIdPk = :typeId ");
		}
		if (year != null && !year.trim().equalsIgnoreCase("")) {
			criterias.append(criterias.toString().equals(queryWhere) ? (" t.year = :year ") : (" and t.year = :year "));
		}
		if (genre != null && !genre.trim().equalsIgnoreCase("")) {
			criterias.append(
					criterias.toString().equals(queryWhere) ? (" t.genre = :genre ") : (" and t.genre = :genre "));
		}
		if (title != null && !title.trim().equalsIgnoreCase("")) {
			criterias.append(
					criterias.toString().equals(queryWhere) ? (" t.title = :title ") : (" and t.title = :title "));
		}
		queryString.append(criterias);
		if (topRated != null && topRated) {
			queryString.append(" order by t.imdbRating desc ");
		}
		Query query = em.createQuery(queryString.toString());
		if (typeId != null && !typeId.trim().equalsIgnoreCase("")) {
			query.setParameter(typeId, typeId);
		}
		if (year != null && !year.trim().equalsIgnoreCase("")) {
			query.setParameter(year, year);
		}
		if (genre != null && !genre.trim().equalsIgnoreCase("")) {
			query.setParameter(genre, genre);
		}
		if (title != null && !title.trim().equalsIgnoreCase("")) {
			query.setParameter(title, title);
		}
		query.setFirstResult(fromTableIndex);
		query.setMaxResults(fetchCount);
		return (List<Title>) query.getResultList();
	}

	@Override
	public int findTotalCustomizedSearchTitleCount(Integer typeId, String year, String genre, String title,
			Boolean topRated) throws Exception {
		StringBuffer queryString = new StringBuffer("Select count(1) from Title t");
		String queryWhere = " where t.deleteFlag = 1 ";
		StringBuffer criterias = new StringBuffer(queryWhere);
		if (typeId != null) {
			criterias.append(" t.titleType.codeMasterIdPk = :typeId ");
		}
		if (year != null && !year.trim().equalsIgnoreCase("")) {
			criterias.append(criterias.toString().equals(queryWhere) ? (" t.year = :year ") : (" and t.year = :year "));
		}
		if (genre != null && !genre.trim().equalsIgnoreCase("")) {
			criterias.append(
					criterias.toString().equals(queryWhere) ? (" t.genre = :genre ") : (" and t.genre = :genre "));
		}
		if (title != null && !title.trim().equalsIgnoreCase("")) {
			criterias.append(
					criterias.toString().equals(queryWhere) ? (" t.title = :title ") : (" and t.title = :title "));
		}
		queryString.append(criterias);
		Query query = em.createQuery(queryString.toString());
		if (typeId != null) {
			query.setParameter(typeId, typeId);
		}
		if (year != null && !year.trim().equalsIgnoreCase("")) {
			query.setParameter(year, year);
		}
		if (genre != null && !genre.trim().equalsIgnoreCase("")) {
			query.setParameter(genre, genre);
		}
		if (title != null && !title.trim().equalsIgnoreCase("")) {
			query.setParameter(title, title);
		}
		return query.executeUpdate();
	}

	@Override
	public UserTitleRating updateTitleRating(UserTitleRating utr) throws Exception {
		return em.merge(utr);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> fetchNewUserTitleAverage(Integer titleId) throws Exception {
		Query query = em.createQuery(
				"Select count(*),sum(utr.rating) from UserTitleRating utr where " + "utr.titleIdFk = :titleId");
		query.setParameter("titleId", titleId);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public UserTitleRating fetchUserTitleRating(Integer titleId, Integer userId) throws Exception {
		Query query = em.createQuery("Select utr from UserTitleRating utr where utr.title.titleIdPk=:titleIdPk "
				+ "and utr.account.accountIdPk=:accountIdPk");
		query.setParameter("titleIdPk", titleId);
		query.setParameter("accountIdPk", userId);

		List<UserTitleRating> list = query.getResultList();
		UserTitleRating entity = (list != null && !list.isEmpty()) ? list.get(0) : null;
		return entity;
	}

}
