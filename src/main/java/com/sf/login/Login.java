package com.sf.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.context.WebApplicationContext;

import com.sf.commonbase.BaseHttpServlet;

public class Login extends BaseHttpServlet {
	
	private void login(HttpServletRequest req,HttpServletResponse rsp)
	{
		try {
			PrintWriter writer = rsp.getWriter();
			getLogger().info("111111111111111111111");
			
//			Configuration config = new Configuration().configure();
//			SessionFactory factory = config.buildSessionFactory();
			WebApplicationContext context = (WebApplicationContext) getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
			SessionFactory factory = (SessionFactory) context.getBean("seesionFactory");
			Session session = factory.openSession();
			
			Users users = session.get(Users.class, 24);
			
			writer.write("hahahhahhhhhhhhhhhaaaaaaaa");
			writer.write(users.USERS_NAME);
		} catch (IOException e) {
			getLogger().error("错误");;
		} catch (HibernateException e){
			getLogger().error(e);
		}
		
	}
}
