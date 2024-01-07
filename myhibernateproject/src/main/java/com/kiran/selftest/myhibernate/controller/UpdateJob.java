package com.kiran.selftest.myhibernate.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kiran.selftest.myhibernet.model.Job;

public class UpdateJob {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
		Session session = factory.openSession();
		Transaction t= session.beginTransaction();
		Job j = new Job();
		j.setId(2);
		j.setName("Software Developer ");
		session.merge(j);
		session.getTransaction().commit();
		session.close();
		

	}

}
