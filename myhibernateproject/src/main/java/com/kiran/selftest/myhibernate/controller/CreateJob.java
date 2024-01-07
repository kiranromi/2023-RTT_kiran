package com.kiran.selftest.myhibernate.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kiran.selftest.myhibernet.model.Job;

public class CreateJob {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Job j = new Job();
		j.setName("HR");
		j.setCompany("Apple");
		
		Job j1 = new Job();
		j1.setName("Developer");
		j1.setCompany("ALLY");
		session.persist(j);
		session.persist(j1);
		 t.commit();
	System.out.println("Successfully saved");
	factory.close();
	session.close();
				
		
		
		
	

	}

}
