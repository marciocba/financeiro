package com.livro.capitulo4.model.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static final SessionFactory sessionFactory=buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
		/*	Configuration cfg=new Configuration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
	*/
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable e) {
			System.out.println("(HibernateUtil) erro sessionFactory"+e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}
	public static SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return sessionFactory;
	}
}
