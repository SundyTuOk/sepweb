package com.sf.commonbase;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PreStartWeb implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		String log4jPath = servletContext.getInitParameter("log4jConfigLocation");
//		String customizedPath = log4jPath;
	    System.setProperty("log4j.configuration", log4jPath);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}
}
