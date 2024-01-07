package com.kiran.capstone.techassistant.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import com.kiran.capstone.techassistant.dto.response.EmployerDTO;
import com.kiran.capstone.techassistant.dto.response.InterviewerDTO;
import com.kiran.capstone.techassistant.entity.User;
import com.kiran.capstone.techassistant.service.UserService;

public class UserControllerTest {

    @Test
    public void testGetListOfInterviewers() {
        UserService userService = mock(UserService.class);
        Model model = mock(Model.class);

        // Create a list of InterviewerDTO - Replace with actual DTO object
        List<InterviewerDTO> interviewerList = new ArrayList<>();
        InterviewerDTO interviewer1 = new InterviewerDTO();
        // Set properties for interviewer1
        InterviewerDTO interviewer2 = new InterviewerDTO();
        // Set properties for interviewer2
        interviewerList.add(interviewer1);
        interviewerList.add(interviewer2);

        when(userService.getListOfInterviewers()).thenReturn(interviewerList);

        UserController userController = new UserController(userService);

        ResponseEntity<List<InterviewerDTO>> responseEntity = userController.getListOfInterviewers(model);

        assertEquals(2, responseEntity.getBody().size());
        assertEquals(MediaType.APPLICATION_OCTET_STREAM, responseEntity.getHeaders().getContentType());
        assertEquals(interviewerList, responseEntity.getBody());
    }

    @Test
    public void testListAllUser() {
        UserService userService = mock(UserService.class);
        Model model = mock(Model.class);

        // Create a list of User - Replace with actual User object
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        // Set properties for user1
        User user2 = new User();
        // Set properties for user2
        userList.add(user1);
        userList.add(user2);

        when(userService.getAllUsers()).thenReturn(userList);

        UserController userController = new UserController(userService);

        String viewName = userController.listAllUser(model);

        assertEquals("users", viewName);
        assertEquals(2, userList.size()); // Verify the size of the user list
    }
    
    @Test
    public void testGetListOfEmployers() {
        UserService userService = mock(UserService.class);
        Model model = mock(Model.class);

        // Create a list of EmployerDTO - Replace with actual EmployerDTO object
        List<EmployerDTO> employerList = new ArrayList<>();
        EmployerDTO employer1 = new EmployerDTO();
        // Set properties for employer1
        EmployerDTO employer2 = new EmployerDTO();
        // Set properties for employer2
        employerList.add(employer1);
        employerList.add(employer2);

        when(userService.getListOfEmployers()).thenReturn(employerList);

        UserController userController = new UserController(userService);

        String viewName = userController.getListOfEmployers(model);

        assertEquals("forward:/employers", viewName);
        assertEquals(2, employerList.size()); // Verify the size of the employer list
       
    }
    @Test
    public void testGetInterviwersByTechnology() {
        UserService userService = mock(UserService.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        UserController userController = new UserController(userService);

        int technologyId = 123; // Replace with the desired technology ID

        // Create a list of User - Replace with actual User objects
        List<User> interviewers = new ArrayList<>();
        User user1 = new User();
        // Set properties for user1
        User user2 = new User();
        // Set properties for user2
        interviewers.add(user1);
        interviewers.add(user2);

        when(userService.findByAreaOfSME(technologyId)).thenReturn(interviewers);

        ResponseEntity<List<User>> responseEntity = userController.getInterviwersBytechnology(response, technologyId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals(interviewers, responseEntity.getBody());
    }
}