package com.kiran.thestudent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kiran.thestudent.dto.StudentDto;
import com.kiran.thestudent.model.Student;


public interface StudentService {
	void saveStudent(StudentDto studentDto);
	   Student findStudentByEmail(String email);
	   List<StudentDto> findAllStudents();


}
