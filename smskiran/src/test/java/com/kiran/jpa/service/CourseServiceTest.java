package com.kiran.jpa.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.kiran.jpa.entitymodels.Course;

public class CourseServiceTest {

	@Test
	public void testGetAllCourses() {
		CourseService cs = new CourseService();
		//Get Course list and see list is not null    	

		List<Course> listAllCourses = cs.getAllCourses();

		// Add assertions to verify the expected outcome of the test
		assertNotNull(listAllCourses); // this should not null as list contains courses.
	}
	@Test
	public void testGetCourseById() {
		CourseService cs = new CourseService();
		//Get Course object and see list is not null 
		int cid =1;

		Course course = cs.getCourseById(cid);

		// Add assertions to verify the expected outcome of the test
		assertNotNull(course); // this should not null as this will return course.
	}
	@Test
	public void testGetCourseByNotValidId() {
		CourseService cs = new CourseService();
		//Get Course object and see list is not null 
		int cid =11111;

		Course course = cs.getCourseById(cid);

		// Add assertions to verify the expected outcome of the test
		assertNull(course); // this should return Null course object as id is not valid.
	}

}
