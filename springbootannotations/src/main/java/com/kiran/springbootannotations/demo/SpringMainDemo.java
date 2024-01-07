package com.kiran.springbootannotations.demo;


	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

	public class SpringMainDemo {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com.kiran.springbootannotations");
			context.refresh();

			MathComponent ms = context.getBean(MathComponent.class);
			int result = ms.add(2, 2);
			System.out.println("Addition of 2 and 2 = " + result);
			context.close();

		}

	}


