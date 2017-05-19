package com.sample.spring;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.sample.spring.utils.ApplicationFilter;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		//ApplicationConstants.getOutput().add("Searching for users..");
		//ApplicationConstants.getOutput().add(".");
		//ApplicationConstants.getOutput().add("AppInitializer.class: Initializing configuration classes..  ");
		return new Class[] { AppConfig.class, JPAConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/api/*"};
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new ApplicationFilter() };
	}

}
