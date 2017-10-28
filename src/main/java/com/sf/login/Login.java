package com.sf.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;

import com.sf.commonbase.BaseHttpServlet;
import com.sf.domain.Users;
import com.sf.service.UserService;

public class Login extends BaseHttpServlet {
	
	private void login(HttpServletRequest req,HttpServletResponse rsp)
	{
		try {
			PrintWriter writer = rsp.getWriter();
			getLogger().info("111111111111111111111");
			
//			Configuration config = new Configuration().configure();
//			SessionFactory factory = config.buildSessionFactory();
			WebApplicationContext context = (WebApplicationContext) getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
			SessionFactory factory = (SessionFactory) context.getBean("sesionFactory");
			Session session = factory.openSession();
			
			UserService dao = (UserService) context.getBean("userService");
			
			Users user = dao.find(24);
			
//			List<Users> queryAll = dao.queryAll(Users.class);
//			Users users = queryAll.get(0);
//			System.out.println(users.getUsersName());
			
			
//			Users users = session.get(Users.class, 24);
			
			writer.write("hahahhahhhhhhhhhhhaaaaaaaa<br/>");
			writer.write(user.getUsersName());
		} catch (IOException e) {
			getLogger().error("错误");;
		} catch (HibernateException e){
			getLogger().error(e);
		}
		
	}
}
