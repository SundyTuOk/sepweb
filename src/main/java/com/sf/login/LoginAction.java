package com.sf.login;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

public class LoginAction implements ServletContextAware{

    private ServletContext servletContext;

    public String driverClass;

    public String login(){
        WebApplicationContext context =
                (WebApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        SessionFactory bean = (SessionFactory) context.getBean("sessionFactory");
        Session session = bean.openSession();
//        session.s
//        driverClass = bean.getDriverClass();
        driverClass = "我就是啦啦啦啦";
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
