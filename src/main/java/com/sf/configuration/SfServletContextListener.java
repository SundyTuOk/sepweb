package com.sf.configuration;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * @author tuzhaoliang
 *	这个listener在web启动时被加载1次
 *	作用：初始化一些web配置
 *	
 */
public class SfServletContextListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		//启动web项目时配置log4j
		String classpath = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
		PropertyConfigurator.configure(classpath + File.separator + "log4j"+File.separator+"log4j.properties");
		System.out.println(classpath.substring(1)+ "log4j"+File.separator+"log4j.properties");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	
}
