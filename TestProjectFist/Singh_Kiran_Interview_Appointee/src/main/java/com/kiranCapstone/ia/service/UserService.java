package com.kiranCapstone.ia.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.kiranCapstone.ia.dto.request.LoginRequestDTO;
import com.kiranCapstone.ia.dto.request.RegisterRequestDTO;
import com.kiranCapstone.ia.dto.response.EmployerDTO;
import com.kiranCapstone.ia.dto.response.InterviewerDTO;
import com.kiranCapstone.ia.entity.User;

public interface UserService {

	public List<User> getAllUsers();

	public List<InterviewerDTO> getListOfInterviewers();

	public List<EmployerDTO> getListOfEmployers();

	User registerUser(RegisterRequestDTO registerRequest);

	boolean authenticateUser(@Valid LoginRequestDTO loginRequest, HttpServletResponse response) throws Exception;

	public void logout(String authorization);

}
