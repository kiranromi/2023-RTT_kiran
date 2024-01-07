package com.kiran.capstone.techassistant.service.impl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kiran.capstone.techassistant.dto.response.EmployerDTO;
import com.kiran.capstone.techassistant.dto.response.InterviewerDTO;
import com.kiran.capstone.techassistant.entity.User;
import com.kiran.capstone.techassistant.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	@Test
	public void testGetAllUsers() {
		// Prepare mock User list
		List<User> mockUsers = new ArrayList<>();
		// Add mock User objects to mockUsers list

		// Mock behavior of userRepository.findAll()
		when(userRepository.findAll()).thenReturn(mockUsers);

		// Call the method under test
		List<User> result = userService.getAllUsers();

		// Assertions
		assertEquals(mockUsers, result); // Check if the returned list matches the mock list
		
	}

	@Test
	public void testGetListOfInterviewers() {
		// Prepare mock InterviewerDTO list
		List<InterviewerDTO> mockInterviewers = new ArrayList<>();
		// Add mock InterviewerDTO objects to mockInterviewers list

		// Mock behavior of userRepository.findInterviewers()
		when(userRepository.findInterviewers()).thenReturn(mockInterviewers);

		// Call the method under test
		List<InterviewerDTO> result = userService.getListOfInterviewers();

		// Assertions
		assertEquals(mockInterviewers, result); // Check if the returned list matches the mock list
		
	}

	@Test
	public void testGetListOfEmployers() {
		// Prepare mock EmployerDTO list
		List<EmployerDTO> mockEmployers = new ArrayList<>();
		// Add mock EmployerDTO objects to mockEmployers list

		// Mock behavior of userRepository.findEmployers()
		when(userRepository.findEmployers()).thenReturn(mockEmployers);

		// Call the method under test
		List<EmployerDTO> result = userService.getListOfEmployers();

		// Assertions
		assertEquals(mockEmployers, result); // Check if the returned list matches the mock list
		
	}

	@Test
	public void testFindByAreaOfSME() {
		// Prepare a mock list of User objects
		List<User> mockUsers = new ArrayList<>();
		// Add mock User objects to mockUsers list

		// Mock behavior of userRepository.findByAreaOfSME()
		when(userRepository.findByAreaOfSME(anyInt())).thenReturn(mockUsers);

		// Call the method under test
		List<User> result = userService.findByAreaOfSME(1); // Pass a sample technology value

		// Assertions
		assertEquals(mockUsers, result); // Check if the returned list matches the mock list
		
	}

	@Test
	public void testFindUserByID() {
		// Prepare a mock User object
		User mockUser = new User();
		// Set necessary properties in mockUser

		// Mock behavior of userRepository.findById()
		when(userRepository.findById(anyLong())).thenReturn(Optional.of(mockUser));

		// Call the method under test
		User result = userService.findUserByID(1L); // Pass a sample ID

		// Assertions
		assertNotNull(result); // Check if the returned User object is not null
		assertEquals(mockUser, result); // Check if the returned User matches the mock User
		
	}
}