package com.sf.login.dao;

import com.sf.db.domain.User;

public interface UsersDAO {
	public User getUserById(Integer id);
	public User getUserByUsername(String username);
	public String getPasswordByUsername(String username);
}
