package com.kiran.jpa.dao;

import java.util.List;

import com.kiran.jpa.entitymodels.Course;


public interface CourseDao {
	List<Course>getAllCourses();

	Course getCourseById(Integer cId);

}
