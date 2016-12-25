package io.egen.movieflix;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import io.egen.movieflix.utils.ApplicationFilter;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class, JPAConfig.class, SwaggerConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/api/*"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[]{new ApplicationFilter()};
	}

}
