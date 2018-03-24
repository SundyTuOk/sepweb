package com.sf.login.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sf.db.domain.User;
import com.sf.login.dao.UsersDAO;
import com.sf.utils.CommonUtils;
import com.sf.utils.Constant;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService{
	
	private Logger logger = Logger.getLogger(LoginServiceImpl.class);
	
	@Resource(name="usersDAO")
	private UsersDAO userDAO;

	/**
	 * 验证用户名和密码是否正确
	 * 前台要用js保证用户名密码是否为空，这里不作判空处理，以免浪费后台资源
	 * @param username
	 * @param password
	 * @return
	 */
	public Map<String,Object> verifyUsernameAndPassword(String inputUsername,String inputPassword){
		// 返回结果的验证结果的map
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		User user = getUserByUsername(inputUsername);
		if(user == null){
			logger.debug("inputUsername->"+inputUsername+",inputPassword->"+inputPassword);
			logger.info("用户不存在");
			resultMap.put(Constant.VERIFY_STATE, false);
			resultMap.put(Constant.VERIFY_MSG, "用户不存在");
			return resultMap;
		}
		
		String md5Password = CommonUtils.md5Password(inputPassword);
		String password = user.getUserPassword();
		if(!md5Password.equals(password)){
			logger.debug("inputUsername->"+inputUsername+",inputPassword->"+inputPassword);
			logger.info("密码错误");
			resultMap.put(Constant.VERIFY_STATE, false);
			resultMap.put(Constant.VERIFY_MSG, "密码错误");
			return resultMap;
		}
		
		resultMap.put(Constant.VERIFY_STATE, true);
		resultMap.put(Constant.LOGIN_USER_NICKNAME, user.getUserNickName());
		return resultMap;
	}

	public User getUserById(Integer id) {
		return userDAO.getUserById(id);
	}

	public User getUserByUsername(String username) {
		return userDAO.getUserByUsername(username);
	}

	
}
