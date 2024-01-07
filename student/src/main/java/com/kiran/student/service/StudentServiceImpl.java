package com.kiran.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.student.entity.Student;
import com.kiran.student.repository.StudentRepository;
@Service
public class StudentServiceImpl {
	
	@Autowired
	StudentRepository studentRepository;
	public List<Student> findAllStudents() {
		List<Student> students = studentRepository.findAll();
		return students;
	}
	public Optional<Student> findStudentById(Long id) {
		;
		return studentRepository.findById(id);
	}
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
	public void save(Student student) {
		studentRepository.save(student);
	}


}
