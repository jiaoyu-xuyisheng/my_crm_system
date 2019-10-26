package com.jiaoyu.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiaoyu.dao.impl.UserDaoImpl;
import com.jiaoyu.domain.my_user;
import com.jiaoyu.service.UserService;

public class demo1_hibernate {
	@Test
	public void fun1() {
		//获取配置文件对象;
		Configuration cf=new Configuration().configure();
		SessionFactory factory = cf.buildSessionFactory();
		Session session= factory.openSession();
		Transaction ts = session.beginTransaction();
		my_user u=new my_user();
		u.setU_uname("laowan");
		u.setU_upassword("laowan");
		session.save(u);
		ts.commit();
		session.close();
		
	}
	
	//从spring中得到sessionFactory;
	@Test
	public void fun2() {
		//获取配置文件对象;
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
		Session session= factory.openSession();
		Transaction ts = session.beginTransaction();
		my_user u=new my_user();
		u.setU_uname("jiujiu");
		u.setU_upassword("jiujiu");
		session.save(u);
		ts.commit();
		session.close();
		
	}
	
	@Test
	public void fun3() {
		//获取配置文件对象;
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
		UserDaoImpl udi=(UserDaoImpl) ac.getBean("userDao");
		my_user u = udi.getByUserCode("laoxu");
		System.out.println(u);
		
	}
	
	@Test
	public void fun4() {
		//获取配置文件对象;
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory factory = (SessionFactory) ac.getBean("sessionFactory");
		UserService us=(UserService) ac.getBean("userService");
		my_user u=new my_user();
		u.setU_uname("xuxu");
		u.setU_upassword("bugaoxuni");
		us.saveDao(u);
		System.out.println("you are success");
		
	}

}
