package com.kiran.selftest.myhibernate.controller;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.kiran.selftest.myhibernet.model.Job;

public class DeleteJob {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
	
		org.hibernate.Transaction t = session.beginTransaction();
		Job j = new Job();
		j.setId(1);
		session.remove(j);
		t.commit();
	    session.close();
	    factory.close();
	

	}

}
