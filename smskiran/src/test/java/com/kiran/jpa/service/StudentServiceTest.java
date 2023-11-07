package com.kiran.jpa.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.kiran.jpa.entitymodels.Course;
import com.kiran.jpa.entitymodels.Student;

public class StudentServiceTest {

	@Test
	public void testValidStudent() {
		StudentService sc = new StudentService();
		String email = "hluckham0@google.ru";
		String password = "X1uZcoIh0dj";

		boolean actual = sc.validateStudent(email, password);
		assertTrue(actual); //this should be true for a valid student
	}

	@Test
	public void testNotValidStudent() {
		StudentService sc = new StudentService();
		//check condition if both email and password not valid
		String email = "kiran@gmail.com";
		String password = "myPassword";

		boolean actual = sc.validateStudent(email, password);        

		assertFalse(actual); // this should be false for a not valid student
	}

	@Test
	public void testGetAllStudent() {
		StudentService sc = new StudentService();
		//Get Student list and see list is not null    	

		List<Student> listAllStudent = sc.getAllStudents();

		// Add assertions to verify the expected outcome of the test
		assertNotNull(listAllStudent); // this should not null as list will not be empty
	}
	@Test
	public void getGetStudentByEmail() {
		StudentService sc = new StudentService();
		String email = "hluckham0@google.ru";

		Student student = sc.getStudentByEmail(email);

		// Add assertions to verify the expected outcome of the test
		assertNotNull(student); // this should not null as this will return student object
	}

	@Test
	public void testGetStudentCourses() {
		StudentService sc = new StudentService();

		//Get StudentCourse list and see list is not null    	
		String email = "sbowden1@yellowbook.com";
		List<Course> listAllCourses = sc.getStudentCourses(email);

		// Add assertions to verify the expected outcome of the test
		assertNotNull(listAllCourses); // this should not null as list will not be empty
	}    

}
