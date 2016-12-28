package com.sample.spring.utils;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(value = "/*")
public class ApplicationFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ApplicationFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			System.out.println("** In authorization filter");
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			//HttpServletResponse httpResponse = (HttpServletResponse) response;
			HttpSession session = httpRequest.getSession();
			System.out.println("Session id: " + session.getId());
			System.out.println("User: " + httpRequest.getRemoteUser());
			String URI = httpRequest.getRequestURI();
			System.out.println("URI: " + URI);
			
			//TODO authentication

			chain.doFilter(request, response);
		} catch (Exception e) {
			System.out.println("Error");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
