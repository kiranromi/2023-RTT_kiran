package com.kiran.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiran.student.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findAll();
	Student findStudentById(Long id);

}
