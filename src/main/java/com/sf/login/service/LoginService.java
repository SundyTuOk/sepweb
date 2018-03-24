package com.sf.login.service;

import java.util.Map;

import com.sf.db.domain.User;

public interface  LoginService {
	public User getUserById(Integer id);
	public User getUserByUsername(String username);
	/**
	 * 验证用户名和密码是否正确
	 * 前台要用js保证用户名密码是否为空，这里不作判空处理，以免浪费后台资源
	 * @param username
	 * @param password
	 * @return
	 */
	public Map<String,Object> verifyUsernameAndPassword(String inputUsername,String inputPassword);
}
