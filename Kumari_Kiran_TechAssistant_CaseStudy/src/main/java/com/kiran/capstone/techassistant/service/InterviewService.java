package com.kiran.capstone.techassistant.service;

import java.io.IOException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.kiran.capstone.techassistant.dto.request.AddInterviewRequestDTO;
import com.kiran.capstone.techassistant.dto.request.FeedbackDTO;
import com.kiran.capstone.techassistant.dto.response.InterviewDTO;
import com.kiran.capstone.techassistant.entity.Interview;

/**
 * Interface class to handle Interview related operations.
 */
@Transactional
public interface InterviewService {

	public  Interview getInterviewById(Long interviewId);
	
	public List<InterviewDTO> getAllInterviews();

	public List<InterviewDTO> getAllActiveInterviews();
	
	public List<InterviewDTO> getAllInterviewsByUserId(int userType, long userId);

	public List<InterviewDTO> getAllActiveInterviewsByUserId(String userType, long userId) throws Exception;

	public Interview addInterview(AddInterviewRequestDTO interviewRequestDTO) throws IOException;

	int assignInterview(Long interviewerId, Long interviewId);

	public List<String> getSupportedTechnologiesList();

	public void provideFeedback(FeedbackDTO feedbackDTO);

}
