package com.sf.login.controller;


public class Test {
	
	private String userName;
	private String passWord;
//	private Long phoneNumber;
	
	public String test(){
//		ServletContext servletContext = ServletActionContext.getServletContext();
//		WebApplicationContext wac=(WebApplicationContext)servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		
//		UsersDAO usersDAO = (UsersDAO) wac.getBean("UsersDAO");
//		User users = usersDAO.getUser(1);
//		System.out.println(users.getUserName());
//		System.out.println(users.getUserID());
		
		//第一种获取requet对象方法---HttpServletRequest对象的attributes(解耦)  
//		Map<String, Object> request = (Map)ActionContext.getContext().get("request"); 
		System.out.println(userName);
		System.out.println(passWord);
		return "success";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
