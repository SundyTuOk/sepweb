package com.sf.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sf.login.dao.UsersDAO;
import com.sf.utils.SpringContextUtil;

@Controller  
@RequestMapping("/login")
public class Login {
	
	@RequestMapping(value="/loginCheck",method=RequestMethod.POST) 
	private String login(String username,String password,String verificationCode)
	{
		System.out.println(username);
		System.out.println(password);
		System.out.println(verificationCode);
		UsersDAO dao = SpringContextUtil.getBean("UsersDAO");
		System.out.println(dao.getUserById(1).getUserName());
//		response.sendRedirect("https://www.baidu.com");
		return "login/login.jsp";
	}
}
