package com.sf.login;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

public class LoginAction implements ServletContextAware{

    private ServletContext servletContext;

    public String driverClass;

    public String login(){
        return "success";
    }

    public void setServletContext(ServletContext context) {
        this.servletContext = context;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }
}
