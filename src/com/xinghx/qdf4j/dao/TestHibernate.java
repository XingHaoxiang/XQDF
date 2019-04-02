package com.xinghx.qdf4j.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();
		s.beginTransaction();

		UserDao p = new UserDao();
		p.setAge(12);
		p.setName("this is name");
		p.setAddress("beijing");
		p.setGender(1);
		p.setPhone("123456");
		s.save(p);

		s.getTransaction().commit();
		UserDao user = (UserDao)s.get(UserDao.class, 1);
		System.out.println(user.toString());
		s.close();
		sf.close();
		
		
	}

}
