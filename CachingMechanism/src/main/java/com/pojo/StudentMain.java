package com.pojo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentMain {

	static StudentEntity s = null;
	static Address a = null;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Address ad1 = new Address(411043, "Pune");
		StudentEntity s1 = new StudentEntity(101, "Ak", ad1);
		Address ad2 = new Address(412408, "Mumbai");
		StudentEntity s2 = new StudentEntity(102, "Mahesh", ad2);

		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory();

		/**
		 * First level cache:- is session level cache & it is bydefault enable
		 * Second level cache:- is sessionfactory level cache to enable second
		 * level we use third party provider like ehcache,os,swarm.
		 * requirements-add dependencies of ehcache and hibernate & ehcache
		 * integration and make it entity class as a @cachable and @cache for
		 * define strategy. Query cache:-it is also sessionfactory level cache &
		 * to enable query cache we should enable the second level cache and
		 * property in cfg file.
		 * 
		 */

		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
//		 s = session1.get(StudentEntity.class, 101);
//		 System.out.println("Session 1*** "+session1.get(StudentEntity.class, 101));
		 
		javax.persistence.Query query1 = session1.createQuery("from StudentEntity where name like 'Mahesh' ")
				.setCacheable(true);
		s = (StudentEntity) query1.getSingleResult();
	
		System.out.println("Session 1` " + s);
		session1.close();

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
//		 s = session2.get(StudentEntity.class, 101);

		javax.persistence.Query query2 = session2.createQuery("from StudentEntity where name like 'Mahesh' ")
				.setCacheable(true);
		s = (StudentEntity) query2.getSingleResult();
		
		System.out.println("Session 2  " + s);
		session2.close();

	}
}