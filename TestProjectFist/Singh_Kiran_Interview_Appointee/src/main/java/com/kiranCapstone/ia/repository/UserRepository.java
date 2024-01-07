package com.kiranCapstone.ia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kiranCapstone.ia.dto.response.EmployerDTO;
import com.kiranCapstone.ia.dto.response.InterviewerDTO;
import com.kiranCapstone.ia.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public List<User> findByUserType(byte type);
	
	@Query("SELECT NEW com.kiranCapstone.ia.dto.response.InterviewerDTO(u.id, u.firstName, u.lastName, u.email, i.areaOfSME, i.yearOfExperiance) " +
            "FROM User u JOIN InterviewerDetails i ON u.id = i.interviewerId " +
            "WHERE u.isActive = 1 and u.userType= 2")
    List<InterviewerDTO> findInterviewers();
	

	@Query("SELECT NEW com.kiranCapstone.ia.dto.response.EmployerDTO(u.id, u.firstName, u.lastName, u.email, u.address) " +
            "FROM User u WHERE u.isActive = 1 and u.userType= 1")
    List<EmployerDTO> findEmployers();

	public User findByUserName(String userName);
}
