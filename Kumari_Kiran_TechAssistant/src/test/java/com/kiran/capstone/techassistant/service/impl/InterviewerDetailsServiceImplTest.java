package com.kiran.capstone.techassistant.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kiran.capstone.techassistant.entity.InterviewerDetails;
import com.kiran.capstone.techassistant.repository.InterviewDetailsRepository;

@ExtendWith(MockitoExtension.class)
public class InterviewerDetailsServiceImplTest {

	@Mock
	private InterviewDetailsRepository detailsRepository;

	@InjectMocks
	private InterviewerDetailsServiceImpl interviewerDetailsService;

	@Test
	public void testUpdateInterviewDetails() {
		// Prepare a mock InterviewerDetails object
		InterviewerDetails mockInterviewerDetails = new InterviewerDetails();
		// Set necessary properties in mockInterviewerDetails

		// Mock behavior of detailsRepository.save()
		when(detailsRepository.save(any())).thenReturn(mockInterviewerDetails);

		// Call the method under test
		InterviewerDetails result = interviewerDetailsService.updateInterviewDetails(mockInterviewerDetails);

		// Assertions
		assertNotNull(result); // Check if the returned InterviewerDetails object is not null
		assertEquals(mockInterviewerDetails, result); // Check if the returned InterviewerDetails matches the mock InterviewerDetails
		
	}


}