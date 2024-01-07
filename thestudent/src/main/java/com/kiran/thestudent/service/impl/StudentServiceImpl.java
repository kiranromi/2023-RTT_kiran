package com.kiran.thestudent.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kiran.thestudent.dto.StudentDto;
import com.kiran.thestudent.model.Role;
import com.kiran.thestudent.model.Student;
import com.kiran.thestudent.repository.RoleRepository;
import com.kiran.thestudent.repository.StudentRepository;
import com.kiran.thestudent.service.StudentService;
@Service
public class StudentServiceImpl  implements StudentService{
	
	private StudentRepository studentRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	
 
 
public StudentServiceImpl(StudentRepository studentRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		super();
		this.studentRepository = studentRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
public void saveStudent(StudentDto studentDto) {
		Student student = new Student();
		student.setName(studentDto.getFirstName() + " " +    studentDto.getLastName());
		student.setEmail(studentDto.getEmail());
		

		// Encrypt the password using Spring Security
		
		
		student.setPassword(passwordEncoder.encode(studentDto.getPassword()));
		Role role = roleRepository.findByName("ROLE_ADMIN");
		if (role == null) {
			role = checkRoleExist();
		}
		student.setRoles(Arrays.asList(role));
	
	
	}
	private Role checkRoleExist() {
		Role role = new Role();
		role.setName("ROLE_ADMIN");
		return roleRepository.save(role);
	}

	@Override
	public Student findStudentByEmail(String email) {
		
		return studentRepository.findByEmail(email);
	}
	@Override
	public List<StudentDto> findAllStudents() {		
	List<Student>students = studentRepository.findAll();
		
	return students.stream()
				.map((student) -> mapToStudentDto(student))
				.collect(Collectors.toList());
	}
	private StudentDto mapToStudentDto(Student student) {
		StudentDto studentDto = new StudentDto();
		
		String[] str = student.getName().split(" ");
		studentDto.setFirstName(str[0]);
		studentDto.setLastName(str[1]);
		studentDto.setEmail(student.getEmail());
		return studentDto;
	}


}
