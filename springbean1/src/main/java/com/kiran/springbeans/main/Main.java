package com.kiran.springbeans.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kiran.springbeans.Student;

public class Main {
  public static void main (String []args) {
	  String config_loc = "/in/sp/resources/applicationContext.xml";
	  ApplicationContext context = new ClassPathXmlApplicationContext(config_loc);
	  Student std = (Student) context.getBean("stdId");
	  std.display();
  }

}
