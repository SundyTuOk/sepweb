package com.sf.commonbase;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class BaseHttpServlet extends HttpServlet{
	
	private Logger logger = Logger.getLogger(this.getClass());

	public Logger getLogger() {
		return logger;
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse rsp)
			throws ServletException, IOException {
		doPost(req,rsp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse rsp)
			throws ServletException, IOException {
		String methodName = (String) req.getParameter("method");
		try {
			Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			logger.info("进入方法:"+methodName);
			method.setAccessible(true);
			method.invoke(this, req,rsp);
			logger.info("退出方法:"+methodName);
		} catch (NoSuchMethodException e) {
			logger.error(e);
		} catch (SecurityException e) {
			logger.error(e);
		} catch (IllegalAccessException e) {
			logger.error(e);
		} catch (IllegalArgumentException e) {
			logger.error(e);
		} catch (InvocationTargetException e) {
			logger.error(e);
		}
	}
}
