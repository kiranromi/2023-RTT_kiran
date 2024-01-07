package com.kiran.selftest.myhibernate.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kiran.selftest.myhibernet.model.Job;

public class FindJob {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		int Job_ID = 2;
		Job j = session.load(Job.class, Job_ID);
		System.out.println("Company: "+ j.getCompany());
		System.out.println("Name  "  + j.getName());
		
		
		
		
		t.commit();
		factory.close();
		session.close();
		
		
		

	}

}
