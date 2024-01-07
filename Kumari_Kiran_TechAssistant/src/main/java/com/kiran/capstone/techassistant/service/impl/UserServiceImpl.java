package com.kiran.capstone.techassistant.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kiran.capstone.techassistant.config.UserSessionHandler;
import com.kiran.capstone.techassistant.constant.SupportedTechnology;
import com.kiran.capstone.techassistant.constant.UserRole;
import com.kiran.capstone.techassistant.dto.request.LoginRequestDTO;
import com.kiran.capstone.techassistant.dto.request.RegisterRequestDTO;
import com.kiran.capstone.techassistant.dto.response.EmployerDTO;
import com.kiran.capstone.techassistant.dto.response.InterviewerDTO;
import com.kiran.capstone.techassistant.entity.Role;
import com.kiran.capstone.techassistant.entity.User;
import com.kiran.capstone.techassistant.repository.UserRepository;
import com.kiran.capstone.techassistant.service.UserService;

/**
 * Service implementation class to handle User related operations.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private EntityManager entityManager;

	private UserRepository userRepository;
	
	/**
	 * Constructor injection for UserService.
	 * 
	 * @param userRepository the userRepository
	 */
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	/**
	 * Retrieve all Users.
	 * 	 
	 * @return List of users
	 */
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * Retrieve all Interviewers.
	 * 	 
	 * @return List of InterviewerDTO
	 */
	@Override
	public List<InterviewerDTO> getListOfInterviewers() {
		return userRepository.findInterviewers();
	}

	/**
	 * Retrieve all Employers.
	 * 	 
	 * @return List of EmployerDTO
	 */
	@Override
	public List<EmployerDTO> getListOfEmployers() {
		return userRepository.findEmployers();
	}

	/**
	 * Operation to register user.
	 * 	 
	 * @return User
	 */
	@Override
	@Transactional
	public User registerUser(RegisterRequestDTO registerRequest) {
		User user = new User();
		user.setUserName(registerRequest.getUserName());
		user.setPassword(registerRequest.getPassword().getBytes());
		user.setEmail(registerRequest.getEmail());
		user.setFirstName(registerRequest.getFirstName());
		user.setLastName(registerRequest.getLastName());
		user.setAddress(registerRequest.getAddress());
		user.setEmployerName(registerRequest.getEmployerName());
		user.setPhone(registerRequest.getPhoneNumber());
		user.setAreaOfSME(registerRequest.getAreaOfSME());
		Role managedRole = entityManager.merge(UserRole.getRoleByType(registerRequest.getUserType()));
		user.setRole(managedRole);
		return userRepository.save(user);
	}

	/**
	 * Operation to authenticate user.
	 * 	
	 * @param loginRequest The LoginRequestDTO to hold login request
	 * @param response The HttpServletResponse to hold response 
	 * @return boolean value
	 */
	public boolean authenticateUser(LoginRequestDTO loginRequest, HttpServletResponse response) throws Exception {
		User user = userRepository.findByUserName(loginRequest.getUsername());
		if (user != null && Arrays.equals(user.getPassword(), loginRequest.getPassword().getBytes())) {
			UserSessionHandler.addUser(user);
			response.setHeader("authorization", UserSessionHandler.getTokenByUserid(user.getId()));
			return true;
		}
		return false;
	}

	/**
	 * Operation to handle logout.
	 */
	@Override
	public void logout(String authorization) {
		UserSessionHandler.removeUserSession(authorization);
	}

	/**
	 * Operation to retrieve SME.
	 * 
	 * @param technology The parameter	 
	 * @return list of Users
	 */
	@Override
	public List<User> findByAreaOfSME(int technology) {
		return userRepository.findByAreaOfSME(technology);
	}

	/**
	 * Operation to retrieve User by Id.
	 * 
	 * @param id The Id parameter	 
	 * @return User
	 */
	@Override
	public User findUserByID(long id) {
		return userRepository.findById(id).orElseGet(null);
	}
	
}
