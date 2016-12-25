package io.egen.movieflix.utils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ApplicationLogger {
	private static final Logger logger = Logger.getLogger(ApplicationLogger.class);
	
	public void error(String errorMessage){
		logger.error(errorMessage);
	}
	
	public void debug(String errorMessage){
		logger.debug(errorMessage);
	}
	
	public void info(String errorMessage){
		logger.info(errorMessage);
	}

}
