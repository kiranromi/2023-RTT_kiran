package com.kiran.capstone.techassistant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kiran.capstone.techassistant.dto.response.EmployerDTO;
import com.kiran.capstone.techassistant.dto.response.InterviewerDTO;
import com.kiran.capstone.techassistant.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT NEW com.kiran.capstone.techassistant.dto.response.InterviewerDTO(u.id, u.firstName, u.lastName, u.email,u.phone, u.areaOfSME) " +
            "FROM User u WHERE u.isActive = 1 and u.role.id= 3")
    List<InterviewerDTO> findInterviewers();
	

	@Query("SELECT NEW com.kiran.capstone.techassistant.dto.response.InterviewerDTO(u.id, u.firstName, u.lastName, u.email,u.phone, u.areaOfSME) " +
            "FROM User u WHERE u.isActive = 1 and u.role.id= 3 and u.areaOfSME = :areaOfSME")
    List<InterviewerDTO> findInterviewersByTechnology(@Param("areaOfSME") String areaOfSME);
	
	
	@Query("SELECT NEW com.kiran.capstone.techassistant.dto.response.EmployerDTO(u.id, u.firstName, u.lastName,u.employerName, u.email,u.phone, u.address) " +
            "FROM User u WHERE u.isActive = 1 and u.role.id= 2")
    List<EmployerDTO> findEmployers();

	public User findByUserName(String userName);
	
	List<User> findByAreaOfSME(int areaOfSME);
}
