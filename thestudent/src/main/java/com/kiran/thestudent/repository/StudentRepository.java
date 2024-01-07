package com.kiran.thestudent.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.kiran.thestudent.model.Student;



public interface StudentRepository extends JpaRepository<Student, Long>{
 
	Student findByEmail(String email);
	
	
	
	
	
	
	
	
	
	
	
	
}


