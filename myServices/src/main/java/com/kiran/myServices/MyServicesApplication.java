package com.kiran.myServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.kiran.myServices"})

public class MyServicesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(MyServicesApplication.class, args);

		Coach theCoach= context.getBean(Coach.class);
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		// call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		// close the context
		context.close();
		}

		

	

}
