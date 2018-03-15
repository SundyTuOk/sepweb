package com.sf.domain;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User{

	// Fields

	private Integer userID;
	private String userName;
//	private String password;

	// Constructors

	/** default constructor */

	// Property accessors
	public User() {
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
//	public String getPassword() {
//		return this.password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
}