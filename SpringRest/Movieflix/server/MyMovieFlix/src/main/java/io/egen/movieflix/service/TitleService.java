package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.entity.Title;
import io.egen.movieflix.entity.UserTitleRating;

public interface TitleService {
	public List<Title> fetchAllTitle(int fromTableIndex, int toTableIndex ) throws Exception;
	public int findTotalTitleCount() throws Exception;
	public List<Title> fetchCustomizedSearchTitle(String type, String year, String genre, 
			String title, Boolean topRated, int fromTableIndex, int toTableIndex) throws Exception;
	/**
	 * find total count of results in customized title search.
	 * 
	 * @param typeId
	 * @param year
	 * @param genre
	 * @param title
	 * @param topRated
	 * @return
	 */
	public int findTotalCustomizedSearchTitleCount(Integer typeId, String year, String genre, String title,
			Boolean topRated) throws Exception;
	public UserTitleRating updateTitleRating(UserTitleRating utr) throws Exception;
	public List<Object[]> fetchNewUserTitleAverage(Integer titleId) throws Exception;

}
