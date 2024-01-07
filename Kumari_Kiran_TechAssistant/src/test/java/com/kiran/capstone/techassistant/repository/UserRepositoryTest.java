package com.kiran.capstone.techassistant.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.kiran.capstone.techassistant.dto.response.EmployerDTO;
import com.kiran.capstone.techassistant.dto.response.InterviewerDTO;
import com.kiran.capstone.techassistant.entity.User;
import com.kiran.capstone.techassistant.service.UserService;
import com.kiran.capstone.techassistant.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

   
    @Mock
    private UserService userService; // Assuming you have a service that uses UserRepository
    
    @BeforeEach
	void setUp() {
		// Initialize mocks
    	
		MockitoAnnotations.openMocks(this);
		userService = new UserServiceImpl(userRepository);
	}


    @Test
    public void testFindInterviewers() {
    	
        List<InterviewerDTO> interviewerList = new ArrayList<>();
        // Populate interviewerList with test data

        // Mock the behavior of userRepository.findInterviewers() to return interviewerList
        when(userRepository.findInterviewers()).thenReturn(interviewerList);

        // Perform your test using userService or directly userRepository
        List<InterviewerDTO> result = userService.getListOfInterviewers();
        
        // Assert the result matches the expected output
        assertEquals(interviewerList.size(), result.size());
       
    }

 
    @Test
    public void testFindEmployers() {
        // Mocked EmployerDTO list
        List<EmployerDTO> mockEmployers = new ArrayList<>();
        mockEmployers.add(new EmployerDTO(1L, "Jane", "Smith", "CompanyX", "jane@example.com", "9876543210", "123 Street"));

        // Mocking the behavior of the UserRepository method
        when(userRepository.findEmployers()).thenReturn(mockEmployers);

        // Invoking the method under test through the service layer (or directly through userRepository)
        List<EmployerDTO> result = userService.getListOfEmployers();

        // Asserting that the mocked list and the returned list are equal
        assertEquals(mockEmployers.size(), result.size());
        assertEquals(mockEmployers.get(0).getEmail(), result.get(0).getEmail());
    }
    
   
    @Test
    public void testFindByAreaOfSME() {
        // Mocked user data with specific areaOfSME
        int areaOfSME = 123;
        User user1 = new User();
        user1.setId(1L);
        user1.setAreaOfSME(areaOfSME);

        User user2 = new User();
        user2.setId(2L);
        user2.setAreaOfSME(areaOfSME);

        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(user1);
        mockUsers.add(user2);

        // Mocking the behavior of the UserRepository method
        when(userRepository.findByAreaOfSME(areaOfSME)).thenReturn(mockUsers);

        // Invoking the method under test through the service layer (or directly through userRepository)
        List<User> result = userService.findByAreaOfSME(areaOfSME);

        // Asserting that the returned list size matches the size of the mocked list
        assertEquals(mockUsers.size(), result.size());
        
    }

}
