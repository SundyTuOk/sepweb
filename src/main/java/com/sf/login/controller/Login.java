package com.sf.login.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sf.db.domain.User;
import com.sf.login.dao.UsersDAO;
import com.sf.login.service.LoginService;
import com.sf.utils.CommonUtils;
import com.sf.utils.Constant;
import com.sf.utils.SpringContextUtil;

@Controller  
@RequestMapping("/login")
public class Login {
	
	private Logger logger = Logger.getLogger(Login.class);
	
	@RequestMapping(value="/login",method=RequestMethod.POST) 
	private ModelAndView login(HttpServletRequest requst,HttpServletResponse response,String username,String password,String verificationCode) throws UnsupportedEncodingException
	{
		String code = (String)requst.getSession().getAttribute(Constant.VERIFY_CODE_KEY);
		System.out.println("verificationCode->"+verificationCode);
		System.out.println("code->"+code);
		System.out.println(logger);
		System.out.println(logger.getName());
		logger.info("test111");
		ModelAndView mv = new ModelAndView();
		LoginService loginService = SpringContextUtil.getBean("loginServiceImpl");
		Map<String, Object> resultMap = loginService.verifyUsernameAndPassword(username, password);
		boolean verifyState = (Boolean) resultMap.get(Constant.VERIFY_STATE);
		
		if(!verifyState){
			mv.setViewName("login/login.jsp");
			mv.addObject("errorMsg", resultMap.get(Constant.VERIFY_MSG));
			return mv;
		}
		String userNickName = (String) resultMap.get(Constant.LOGIN_USER_NICKNAME);
		// 回写cookie 昵称
		Cookie nickNameCookie = CommonUtils.getNewCookie(Constant.LOGIN_USER_NICKNAME,URLEncoder.encode(userNickName, Constant.ENCODING_STYLE));
		response.addCookie(nickNameCookie);
		// 回写cookie 用户id
		Cookie userIDCookie = CommonUtils
				.getNewCookie(Constant.LOGIN_USER_ID
						,URLEncoder.encode(loginService.getUserByUsername(username).getUserID().toString()
								, Constant.ENCODING_STYLE));
		response.addCookie(userIDCookie);
		
		mv.setViewName("login/homePage.jsp");
		mv.addObject("errorMsg", "登录成功,你好:"+userNickName);
		return mv;
	}
	
	@RequestMapping(value="/logout") 
	private ModelAndView logout(HttpServletResponse rsp)
	{
		ModelAndView mv = new ModelAndView("login/login.jsp");
		Cookie cookie = CommonUtils.getNewCookie(Constant.LOGIN_USER_NICKNAME, "");
		cookie.setMaxAge(0);
		rsp.addCookie(cookie);
		return mv;
	}
}
