package io.egen.movieflix.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.movieflix.DTO.TitleDTO;
import io.egen.movieflix.utils.ApplicationUtils;

@Service
public class TitleValidator {

	@Autowired
	ApplicationUtils utils;

	public boolean checkTitleValidity(TitleDTO titleDTO) throws Exception {
		boolean flag = Boolean.TRUE;
		if (titleDTO.getTitle() == null || titleDTO.getTitle().trim().equals("")) {
			flag = Boolean.FALSE;
		}
		if (titleDTO.getYear() == null || titleDTO.getYear().trim().equals("")) {
			flag = Boolean.FALSE;
		}
		if (titleDTO.getReleaseDate() == null || titleDTO.getReleaseDate().trim().equals("")) {
			flag = Boolean.FALSE;
		} else {
			try {
				utils.convertStringToDate(titleDTO.getReleaseDate());
			} catch (Exception e) {
				flag = Boolean.FALSE;
			}
		}
		if (titleDTO.getRuntime() == null || titleDTO.getRuntime().trim().equals("")) {
			flag = Boolean.FALSE;
		}
		if (titleDTO.getDirector() == null || titleDTO.getDirector().trim().equals("")) {
			flag = Boolean.FALSE;
		}
		if (titleDTO.getWriter() == null || titleDTO.getWriter().trim().equals("")) {
			flag = Boolean.FALSE;
		}
		if (titleDTO.getActors() == null || titleDTO.getActors().trim().equals("")) {
			flag = Boolean.FALSE;
		}
		if (titleDTO.getPlot() == null || titleDTO.getPlot().trim().equals("")) {
			flag = Boolean.FALSE;
		}
		if (titleDTO.getImdbId() == null || titleDTO.getImdbId().trim().equals("")) {
			flag = Boolean.FALSE;
		}
		
		return flag;
	}
}
