package com.sf.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.commonbase.BaseHttpServlet;

public class Login extends BaseHttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse rsp)
			throws ServletException, IOException {
		login(req,rsp);
	}
	private String login(HttpServletRequest req,HttpServletResponse rsp)
	{
		return "success";
		
	}
}
