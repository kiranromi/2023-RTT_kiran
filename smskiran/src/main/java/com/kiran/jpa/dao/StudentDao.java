package com.kiran.jpa.dao;

import java.util.List;

import com.kiran.jpa.entitymodels.Course;
import com.kiran.jpa.entitymodels.Student;




public interface StudentDao {

	List<Student>getAllStudents();
	public Student getStudentByEmail(String sEmail);
	public boolean	validateStudent(String sEmail, String sPassword);
	public void registerStudentToCourse(String sEmail, int cId);
	List<Course>getStudentCourses( String sEmail);

}
