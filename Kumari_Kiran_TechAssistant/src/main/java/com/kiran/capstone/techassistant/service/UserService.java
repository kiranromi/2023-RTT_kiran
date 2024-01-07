package com.kiran.capstone.techassistant.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.kiran.capstone.techassistant.dto.request.LoginRequestDTO;
import com.kiran.capstone.techassistant.dto.request.RegisterRequestDTO;
import com.kiran.capstone.techassistant.dto.response.EmployerDTO;
import com.kiran.capstone.techassistant.dto.response.InterviewerDTO;
import com.kiran.capstone.techassistant.entity.User;

/**
 * Interface class to handle User related operations.
 */
public interface UserService {

	public List<User> getAllUsers();

	public List<InterviewerDTO> getListOfInterviewers();

	public List<EmployerDTO> getListOfEmployers();

	User registerUser(RegisterRequestDTO registerRequest);

	boolean authenticateUser(@Valid LoginRequestDTO loginRequest, HttpServletResponse response) throws Exception;

	public void logout(String authorization);

	List<User> findByAreaOfSME(int technology);
	
	User findUserByID(long id);

}
