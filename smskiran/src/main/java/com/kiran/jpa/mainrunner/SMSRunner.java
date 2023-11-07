package com.kiran.jpa.mainrunner;

import java.util.List;
import java.util.Scanner;

import com.kiran.jpa.dao.CourseDao;
import com.kiran.jpa.dao.StudentDao;
import com.kiran.jpa.entitymodels.Course;
import com.kiran.jpa.service.CourseService;
import com.kiran.jpa.service.StudentService;

public class SMSRunner {



	public static void main(String[] args) {

		SMSRunner sms = new SMSRunner();
		StudentDao studentDao = new StudentService();
		CourseDao courseDao = new CourseService();		

		Scanner scan = new Scanner(System.in);
		System.out.println ("Are you a(n)\n 1.Student\n 2.quit\n Please Enter 1 or 2");
		int choice = scan.nextInt();
		if (choice == 1 ) {
			System.out.println("Enter Your Email:");
			String studentEmail = scan.next();
			System.out.println("Enter Your Password:");
			String studentPass = scan.next();
			boolean validStudent = studentDao.validateStudent(studentEmail, studentPass);
			if(validStudent) {
				sms.displayStudentCourses(studentEmail, studentDao);
				System.out.println("\n");
				System.out.println("\n");
				System.out.println ("\t" + "1.Register to Class\n" +"\t"+"2.Logout\n Please Enter 1 or 2");
				choice = scan.nextInt();
				if (choice == 1 ) {
					sms.registerToClass(studentEmail, studentDao, courseDao);					
				}else if (choice == 2 ) {
					System.out.println("You have been signed out.");
				}	

			}else {
				System.out.println("Your either emailid or password is not correct.Not a valid student");
				System.exit(0);
			}



		}else {
			System.out.println("You quit.");
			System.exit(0);
		}


		//List<Student> listStudent = studentService.getAllStudents();
		//System.out.println(listStudent);
		//studentService.registerStudentToCourse("sbowden1@yellowbook.com", 2);
		//studentService.registerStudentToCourse("hluckham0@google.ru", 2);
		//List<Course> listCourses = studentDao.getStudentCourses("hluckham0@google.ru");


	}

	private void displayStudentCourses(String studentEmail, StudentDao studentDao) {
		List<Course> listCourses = studentDao.getStudentCourses(studentEmail);
		System.out.println("My Classes:\n");
		System.out.println("#" + "\t" + "COURSE NAME" + "\t" + "INSTRUCTOR NAME");
		for(Course c : listCourses) {
			System.out.println(c.getcId() + "\t" + c.getcName() + "\t" + c.getcInstructorName());
		}

	}

	private void registerToClass(String studentEmail, StudentDao studentDao, CourseDao courseDao) {

		List<Course> listofAllCourses = courseDao.getAllCourses();
		System.out.println("All Courses:\n");
		System.out.println("#" + "\t" + "COURSE NAME" + "\t" + "INSTRUCTOR NAME");
		for(Course c : listofAllCourses) {
			System.out.println(c.getcId() + "\t" + c.getcName() + "\t" + c.getcInstructorName());
		}

		Scanner scan = new Scanner(System.in);
		System.out.println("\n");
		System.out.println ("\t Which Course?");
		int cid = scan.nextInt();

		studentDao.registerStudentToCourse(studentEmail, cid);
		displayStudentCourses(studentEmail, studentDao);
	}

}
