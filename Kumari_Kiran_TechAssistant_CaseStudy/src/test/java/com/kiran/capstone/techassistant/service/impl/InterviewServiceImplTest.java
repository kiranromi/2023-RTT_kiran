package com.kiran.capstone.techassistant.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kiran.capstone.techassistant.constant.InterviewStatus;
import com.kiran.capstone.techassistant.constant.SupportedTechnology;
import com.kiran.capstone.techassistant.constant.UserRole;
import com.kiran.capstone.techassistant.dto.request.FeedbackDTO;
import com.kiran.capstone.techassistant.dto.response.InterviewDTO;
import com.kiran.capstone.techassistant.entity.Interview;
import com.kiran.capstone.techassistant.repository.InterviewRepository;

// Import relevant classes and dependencies

@ExtendWith(MockitoExtension.class)
public class InterviewServiceImplTest {

	@Mock
	private InterviewRepository interviewRepository;

	@InjectMocks
	private InterviewServiceImpl interviewService;

	@InjectMocks
	private UserServiceImpl userService;


	@Test
	public void testAssignInterview() {
		// Prepare mock parameters for assignInterview method
		Long interviewerId = 1L;
		Long interviewId = 2L;

		// Mock behavior of interviewRepository.assignInterviewToUser()
		when(interviewRepository.assignInterviewToUser(interviewerId, 2, interviewId)).thenReturn(1);

		// Call the method under test
		int result = interviewService.assignInterview(interviewerId, interviewId);

		System.out.println("result = "+result);

		// Assertions
		assertEquals(1, result); // Check if the result is as expected
		
	}
	@Test
	public void testGetAllActiveInterviewsByUserId() throws Exception {
		// Prepare mock parameters for getAllActiveInterviewsByUserId method
		String userType = UserRole.INTERVIEWER.name();
		long userId = 1L;

		// Prepare mock Interview objects and their DTOs
		List<Interview> mockInterviews = new ArrayList<>();
		// Add mock Interview objects to mockInterviews list

		List<InterviewDTO> mockInterviewDTOs = new ArrayList<>();
		// Add mock InterviewDTO objects to mockInterviewDTOs list

		// Mock behavior of interviewRepository methods based on userType and userId
		when(interviewRepository.findByInterviewerIdAndStatus(userId, 1)).thenReturn(mockInterviews);
		// Assuming method mapListofInterviewTDTO correctly maps Interview entities to InterviewDTOs


		// Call the method under test
		List<InterviewDTO> result = interviewService.getAllActiveInterviewsByUserId(userType, userId);

		// Assertions
		assertEquals(mockInterviewDTOs.size(), result.size()); // Check if the size of returned list matches expected
		
	}

	@Test
	public void testGetSupportedTechnologiesList() {
		// Mock the SupportedTechnology enum values
		SupportedTechnology[] mockedTechnologiesArray = { SupportedTechnology.JAVA, SupportedTechnology.DOTNET,SupportedTechnology.FullStack, SupportedTechnology.DB,
				SupportedTechnology.DB_ADMIN,SupportedTechnology.FRONTEND,SupportedTechnology.DEVOPS,SupportedTechnology.CLOUD,
				SupportedTechnology.GO,SupportedTechnology.SCRUM_MASTER,SupportedTechnology.PYTHON};



		// Mock the behavior of SupportedTechnology.values()
		//  when(SupportedTechnology.values()).thenReturn(mockedTechnologiesArray);

		// Call the method under test
		List<String> result = interviewService.getSupportedTechnologiesList();

		// Expected result from mocked values
		List<String> expectedList = new ArrayList<>();
		for (SupportedTechnology technology : mockedTechnologiesArray) {
			expectedList.add(technology.name());
		}
		// Assertions
		assertEquals(expectedList.size(), result.size()); // Check if the sizes of lists match
		assertEquals(expectedList, result); // Check if the lists contain the same elements
		
	}

	@Test
	public void testGetAllInterviewsByUserId() {
		// Prepare mock parameters for getAllInterviewsByUserId method
		int userType = UserRole.INTERVIEWER.getType();
		long userId = 1L;

		// Prepare mock Interview objects
		List<Interview> mockInterviews = new ArrayList<>();
		// Add mock Interview objects to mockInterviews list

		List<InterviewDTO> mockInterviewDTOs = new ArrayList<>();
		// Add mock InterviewDTO objects to mockInterviewDTOs list

		// Mock behavior of interviewRepository methods based on userType and userId
		when(interviewRepository.findInterviewsByInterviewerId(userId)).thenReturn(mockInterviews);


		// Call the method under test
		List<InterviewDTO> result = interviewService.getAllInterviewsByUserId(userType, userId);

		// Assertions
		assertEquals(mockInterviewDTOs.size(), result.size()); // Check if the size of returned list matches expected
		
	}

	@Test
	public void testProvideFeedback() {
		// Prepare a mock FeedbackDTO object
		FeedbackDTO feedbackDTO = new FeedbackDTO();
		// Set necessary properties in feedbackDTO

		// Call the method under test
		interviewService.provideFeedback(feedbackDTO);

		// Verify that interviewRepository.provideFeedback() was called with the expected parameters
		verify(interviewRepository, times(1)).provideFeedback(
				eq(feedbackDTO.getInterviewId()), eq(feedbackDTO.getIsSelected()),
				eq(feedbackDTO.getFeedback()), eq(InterviewStatus.COMPLETED.getStatus())
				);
		
	}

	@Test
	public void testGetInterviewById() {
		// Prepare a mock Interview object
		Interview mockInterview = new Interview();
		// Set necessary properties in mockInterview

		// Mock the behavior of interviewRepository.findById()
		when(interviewRepository.findById(anyLong())).thenReturn(Optional.of(mockInterview));

		// Call the method under test
		Interview result = interviewService.getInterviewById(1L); // Pass a sample interview ID

		// Assertions
		assertEquals(mockInterview, result); // Check if the retrieved interview matches the mock interview
		
	}


}
