package com.kiran.capstone.techassistant.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.kiran.capstone.techassistant.dto.response.InterviewDTO;
import com.kiran.capstone.techassistant.service.InterviewService;

@RunWith(value = MockitoJUnitRunner.class)
//@WebMvcTest(InterviewController.class)
public class InterviewControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private InterviewController interviewController;

	@Mock
	private InterviewService interviewService;

	@Mock
	private Model model;
	
	 @Mock
	    private HttpServletRequest httpRequest;
	

	@BeforeEach
	void setUp() {
		// Initialize mocks
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(interviewController).build();
	}

	@Test
    void testGetAllInterviews() {
        // Mock the behavior of the interviewService.getAllInterviews() method
        when(interviewService.getAllInterviews()).thenReturn(Arrays.asList(new InterviewDTO()));
        // Call the getAllInterviews method
        interviewController.getAllInterviews(model);
        // Verify that interviewService.getAllInterviews() is called once
        Mockito.verify(interviewService, Mockito.times(1)).getAllInterviews();
        // Verify that the model.addAttribute() method is called with the correct attribute name and value
        Mockito.verify(model, Mockito.times(1)).addAttribute(Mockito.eq("interviews"), Mockito.anyList());
    }
	
	 @Test
	    public void testAssignInterviewModel() {
	        // Mock the interviewId parameter in the HttpServletRequest
	        when(httpRequest.getParameter("interviewId")).thenReturn("123"); // Replace "123" with your test value
	        
	        // Call the method under test
	        String viewName = interviewController.assignInterviewModel(model, httpRequest);

	        // Verify that the model contains the "interviewId" attribute with the expected value
	        verify(model).addAttribute(eq("interviewId"), eq("123")); // Replace "123" with the expected value

	        // Verify that the view name returned matches the expected view name
	        assertEquals("assign-interview", viewName);
	    }
	 
	 @Test
	    public void testAssignInterview() {
	        // Mock the interviewId and interviewerId parameters in the HttpServletRequest
	        when(httpRequest.getParameter("interviewId")).thenReturn("123"); // Replace "123" with your test value
	        when(httpRequest.getParameter("interviewerId")).thenReturn("456"); // Replace "456" with your test value

	        // Call the method under test
	        String viewName = interviewController.assignInterview(model, httpRequest);

	        // Verify that the interviewService.assignInterview method was called with the expected arguments
	        verify(interviewService).assignInterview(456L, 123L); // Replace "456" and "123" with the expected values

	        // Verify that the view name returned matches the expected view name
	        assertEquals("admin-dashboard", viewName);
	    }
	 
	 @Test
	    public void testGetInterviewList() throws Exception {
	        // Create a sample list of InterviewDTO
	        List<InterviewDTO> sampleList = new ArrayList<>();
	        // Add sample InterviewDTO objects to the list (You can add more if needed)
	        sampleList.add(new InterviewDTO(/* Add necessary constructor parameters */));

	        // Mock the behavior of interviewService.getAllInterviews() method
	        when(interviewService.getAllInterviews()).thenReturn(sampleList);

	        // Call the method under test
	        ResponseEntity<List<InterviewDTO>> response = interviewController.getInterviewList();

	        // Verify that the response status is OK (200)
	        assertEquals(HttpStatus.OK, response.getStatusCode());

	        // Verify that the content type is JSON
	        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());

	        // Verify that the response body contains the sample list of InterviewDTO
	        assertEquals(sampleList, response.getBody());
	    }

	private Object any() {
		// TODO Auto-generated method stub
		return null;
	}

	private String eq(String string) {
		// TODO Auto-generated method stub
		return string;
	}

	

}
