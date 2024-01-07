package com.kiran.jpa.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;


import com.kiran.jpa.entitymodels.Course;

public class CourseServiceTest1{
	@Test
	public void testGetAllCourses1() {
		CourseService cs = new CourseService();
List<Course> listofcourse =cs.getAllCourses();
assertNotNull(listofcourse);
		
	}
		
	
	
	/*
	 * @Test public void testGetCourseById(Integer cId) { CourseService cs = new
	 * CourseService();
	 * 
	 * }
	 */

}
