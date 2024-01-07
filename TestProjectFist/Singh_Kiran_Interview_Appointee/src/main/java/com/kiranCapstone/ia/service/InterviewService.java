package com.kiranCapstone.ia.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kiranCapstone.ia.dto.request.AddInterviewRequestDTO;
import com.kiranCapstone.ia.dto.request.FeedbackDTO;
import com.kiranCapstone.ia.entity.Interview;
import com.kiranCapstone.ia.entity.InterviewerDetails;
import com.kiranCapstone.ia.entity.Resume;

@Transactional
public interface InterviewService {

	public List<Interview> getAllInterviews();

	public List<Interview> getAllActiveInterviews();
	
	public List<Interview> getAllInterviewsByUserId(int userType, long userId);

	public List<Interview> getAllActiveInterviewsByUserId(String userType, long userId) throws Exception;

	public Interview addInterview(AddInterviewRequestDTO interviewRequestDTO);

	int assignInterview(Long interviewerId, Long interviewId);

	public int declineInterview(long id);

	public List<String> getSupportedTechnologiesList();

	public List<InterviewerDetails> getInterviewersByTechnology(String technology);

	public Long uploadResume(MultipartFile file, Long interviewId);

	public Resume getResumeById(Long resumeId);

	public void provideFeedback(FeedbackDTO feedbackDTO);

}
