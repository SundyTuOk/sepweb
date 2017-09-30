package com.sf.login;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

public class LoginAction implements ServletContextAware{

    private ServletContext servletContext;

    private String driverClass;

    public String login(){
//        WebApplicationContext context =
//                (WebApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//        ComboPooledDataSource bean = (ComboPooledDataSource) context.getBean("dataSource");
//        driverClass = bean.getDriverClass();
        driverClass = "我就是啦啦啦啦";
        return "success";
    }

    public void setServletContext(ServletContext context) {

    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }
}
