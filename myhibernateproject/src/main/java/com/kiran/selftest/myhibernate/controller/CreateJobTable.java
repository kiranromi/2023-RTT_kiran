package com.kiran.selftest.myhibernate.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kiran.selftest.myhibernet.model.Job;

public class CreateJobTable {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session= factory.openSession();
		Job j = new Job();
		Transaction t = session.beginTransaction();
		t.commit();
		System.out.println("Successfully created Job table");
		factory.close();
		session.close();

	}

}
