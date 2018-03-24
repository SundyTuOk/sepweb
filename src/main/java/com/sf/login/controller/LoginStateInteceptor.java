package com.sf.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sf.utils.Constant;

/**
 * 登录状态检查拦截器
 * @author tuzhaoliang
 * @date 2018年3月22日
 */
public class LoginStateInteceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse rsp,
			Object handler) throws Exception {
		Cookie[] cookies = req.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals(Constant.LOGIN_USER_NICKNAME)){
				//是登录状态
				return true;
			}
		}
		//是登出状态
		req.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(req, rsp);
		return false;
	}

}
