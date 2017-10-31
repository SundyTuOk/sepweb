package com.sf.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;

import com.sf.commonbase.BaseHttpServlet;
import com.sf.domain.Users;
import com.sf.service.BaseService;

public class Login extends BaseHttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse rsp)
			throws ServletException, IOException {
		login(req,rsp);
	}
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
			
			BaseService dao = (BaseService) context.getBean("baseService");
//			dao.f
			Users user = (Users) dao.find(Users.class, 24);
			
//			List<Users> queryAll = dao.queryAll(Users.class);
//			Users users = queryAll.get(0);
//			System.out.println(users.getUsersName());
			
			
//			Users users = session.get(Users.class, 24);
			
			writer.write("hahahhahhhhhhhhhhhaaaaaaaa<br/>");
			writer.write(user.getUsersName());
			System.out.println(user.getUsersName());
		} catch (IOException e) {
			getLogger().error("错误");;
		} catch (HibernateException e){
			getLogger().error(e);
		}
		
	}
}
