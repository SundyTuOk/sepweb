package com.sf.login;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  
@Scope("prototype")   
@RequestMapping("/user")
public class Login {
	
	@RequestMapping(value="/save",method=RequestMethod.GET) 
	private String login(String userName,HttpServletResponse response) throws IOException
	{
		System.out.println(userName);
//		response.sendRedirect("https://www.baidu.com");
		return "login/login.jsp";
	}
}
