package com.test.hib.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.project.Hib.model.User;



public class FindingUser {
	public static void main(String[] args) {

	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session session = factory.openSession();
	Transaction tx= session.beginTransaction();
	int User_ID = 2;
	User u = session.load(User.class,User_ID);
	System.out.println("Fullname: " + u.getFullname());
	System.out.println("Email: " + u.getEmail());
	System.out.println("password: " + u.getPassword());
	
	//Close resources
	tx.commit();
	factory.close();
	session.close();


}
}