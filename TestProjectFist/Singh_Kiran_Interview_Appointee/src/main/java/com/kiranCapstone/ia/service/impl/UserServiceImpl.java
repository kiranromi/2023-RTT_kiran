package com.kiranCapstone.ia.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kiranCapstone.ia.constant.UserRole;
import com.kiranCapstone.ia.dto.request.LoginRequestDTO;
import com.kiranCapstone.ia.dto.request.RegisterRequestDTO;
import com.kiranCapstone.ia.dto.response.EmployerDTO;
import com.kiranCapstone.ia.dto.response.InterviewerDTO;
import com.kiranCapstone.ia.entity.Role;
import com.kiranCapstone.ia.entity.User;
import com.kiranCapstone.ia.repository.UserRepository;
import com.kiranCapstone.ia.service.UserService;
import com.kiranCapstone.ia.util.UserSessionHandler;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private EntityManager entityManager;

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<InterviewerDTO> getListOfInterviewers() {
		return userRepository.findInterviewers();
	}

	@Override
	public List<EmployerDTO> getListOfEmployers() {
		return userRepository.findEmployers();
	}

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
		user.setUserType(registerRequest.getUserType());
		Role managedRole = entityManager.merge(UserRole.getRoleByType(registerRequest.getUserType()));
		user.setRole(managedRole);
		return userRepository.save(user);
	}

	public boolean authenticateUser(LoginRequestDTO loginRequest, HttpServletResponse response) throws Exception {
		User user = userRepository.findByUserName(loginRequest.getUsername());
		if (user != null && Arrays.equals(user.getPassword(), loginRequest.getPassword().getBytes())) {
			UserSessionHandler.addUser(user);
			response.setHeader("authorization", UserSessionHandler.getTokenByUserid(user.getId()));
			return true;
		}
		return false;
	}

	@Override
	public void logout(String authorization) {
		UserSessionHandler.removeUserSession(authorization);
	}

}
