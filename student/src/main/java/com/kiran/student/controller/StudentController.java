package com.kiran.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.student.entity.Student;
import com.kiran.student.service.StudentServiceImpl;

@RestController
public class StudentController {
		
	
		@Autowired
		StudentServiceImpl studentServiceImpl;
		//Get all students
		//localhost:8080/students
		@GetMapping("/students")
		public List<Student> getAllStudents() {
			List<Student> students = studentServiceImpl.findAllStudents();
			return students;
		}
		//localhost:8080/students/1
		@GetMapping("/students/{id}")
		public Optional<Student> findStudentByID(@PathVariable Long id) {
			Optional<Student> student = studentServiceImpl.findStudentById(id);
			return student;
		}
		@DeleteMapping("/student/{id}")
		public void deleteStudent(@PathVariable("id") long id) {
			studentServiceImpl.deleteStudent(id);
		}
		//localhost:8080/student/add 
		@PostMapping("/student/add")
		@ResponseStatus(code= HttpStatus.CREATED)
		public void addStudent(@RequestBody Student student) {
			studentServiceImpl.save(student); // here we can return html page
		}
		@PutMapping("/student/update/{id}")
		public Student updatesStudentsById(@PathVariable long id) {
			Optional<Student> student = studentServiceImpl.updatesStudentById(id);	
		}
		

}
