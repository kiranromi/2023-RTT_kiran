package com.kiran.capstone.techassistant.service.impl;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.capstone.techassistant.constant.InterviewMode;
import com.kiran.capstone.techassistant.constant.InterviewStatus;
import com.kiran.capstone.techassistant.constant.SupportedTechnology;
import com.kiran.capstone.techassistant.constant.UserRole;
import com.kiran.capstone.techassistant.dto.request.AddInterviewRequestDTO;
import com.kiran.capstone.techassistant.dto.request.FeedbackDTO;
import com.kiran.capstone.techassistant.dto.response.InterviewDTO;
import com.kiran.capstone.techassistant.entity.Interview;
import com.kiran.capstone.techassistant.entity.User;
import com.kiran.capstone.techassistant.repository.InterviewRepository;
import com.kiran.capstone.techassistant.service.InterviewService;
import com.kiran.capstone.techassistant.service.UserService;

/**
 * Service implementation class to handle Interview related operations.
 */
@Service
public class InterviewServiceImpl implements InterviewService {

	private InterviewRepository interviewRepository;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	/**
	 * Constructor injection for interviewService.
	 * 
	 * @param interviewRepository the interviewRepository
	 */
	public InterviewServiceImpl(InterviewRepository interviewRepository) {
		super();
		this.interviewRepository = interviewRepository;
	}

	@Autowired
	UserService userService;
	
	/**
	 * Operation to add Interview.
	 * 
	 * @param AddInterviewRequestDTO The dto parameter to hold the interview request.
	 * @return Interview.
	 */
	@Override
	public Interview addInterview(AddInterviewRequestDTO dto) throws IOException {
		Interview interview = new Interview();
		interview.setStatus(1);
		interview.setModeOfInterview(dto.getMode());
		interview.setRate(SupportedTechnology.getInvoiceAmountByIdAndMode(dto.getTechnology(), dto.getMode()));
		interview.setEmployerId(dto.getEmployerId());		
		interview.setEmail(dto.getCandidateEmail());
		interview.setTechnology(dto.getTechnology());
		interview.setCandidateContact(dto.getCandidateContact());
		interview.setCandidateName(dto.getCandidateName());
		interview.setFileName(dto.getResume().getOriginalFilename());
		interview.setFile(dto.getResume().getBytes());
		interview.setTechnology(dto.getTechnology());
		return interviewRepository.save(interview);
	}

	/**
	 * Operation to assign Interview.
	 * 
	 * @param interviewerId The interviewerId parameter to hold interviewer Id.
	 * @param interviewId The interviewId parameter to hold interview Id.
	 * @return int value to show success/failure.
	 */
	@Override
	public int assignInterview(Long interviewerId, Long interviewId) {
		return interviewRepository.assignInterviewToUser(interviewerId, InterviewStatus.ASSIGNED.getStatus(), interviewId);
	}

	/**
	 * Retrieve all active interviews by user id.
	 * 
	 * @param userType The userType to hold type of user
	 * @param userId The userId to hold userId
	 * @return List of InterviewDTO
	 */
	@Override
	public List<InterviewDTO> getAllActiveInterviewsByUserId(String userType, long userId) throws Exception {
		if (UserRole.INTERVIEWER.name().equalsIgnoreCase(userType)) {
			return mapListofInterviewTDTO(interviewRepository.findByInterviewerIdAndStatus(userId, 1));
		} else if (UserRole.EMPLOYER.name().equalsIgnoreCase(userType)) {
			return mapListofInterviewTDTO(interviewRepository.findByEmployerIdAndStatus(userId, 1));
		} else if (UserRole.ADMIN.name().equalsIgnoreCase(userType)) {
			return mapListofInterviewTDTO(interviewRepository.findByStatus(1));
		} else {
			throw new Exception("Wrong UserType selected");
		}
	}

	/**
	 * Retrieve all Supported Technologies List.
	 * 	 
	 * @return supportedTechnologiesList
	 */
	@Override
	public List<String> getSupportedTechnologiesList() {
		SupportedTechnology[] technologiesArray = SupportedTechnology.values();
		List<SupportedTechnology> technologiesList = Arrays.asList(technologiesArray);
		List<String> supportedTechnologiesList = new ArrayList<>();
		for (SupportedTechnology technology : technologiesList) {
			supportedTechnologiesList.add(technology.name());
		}
		return supportedTechnologiesList;
	}
	
	/**
	 * Retrieve all Interviews.
	 * 	 
	 * @return List of InterviewDTO
	 */
	@Override
	public List<InterviewDTO> getAllInterviews() {
		List<InterviewDTO> list= mapListofInterviewTDTO(interviewRepository.findAllByOrderByStatus());
		for(InterviewDTO dto : list) {
			User user =  userService.findUserByID(dto.getEmployerId());
			dto.setEmployerName(user.getEmployerName());
		}
		return list;
	}
	/**
	 * Retrieve all Active Interviews.
	 * 	 
	 * @return List of InterviewDTO
	 */
	@Override
	public List<InterviewDTO> getAllActiveInterviews() {
		return mapListofInterviewTDTO( interviewRepository.findByStatusIn(Arrays.asList(1, 2, 3)));
	}
	/**
	 * Retrieve all interviews by user id.
	 * 
	 * @param userType The userType to hold type of userType
	 * @param userId The userId to hold userId
	 * @return List of InterviewDTO
	 */
	@Override
	public List<InterviewDTO> getAllInterviewsByUserId(int userType, long userId) {
		if (userType == UserRole.INTERVIEWER.getType()) {
			return mapListofInterviewTDTO(interviewRepository.findInterviewsByInterviewerId(userId));
		} else if (userType == UserRole.EMPLOYER.getType()) {
			return mapListofInterviewTDTO(interviewRepository.findInterviewsByEmployerId(userId));
		} else {
			return mapListofInterviewTDTO( interviewRepository.findByStatus(1));
		}
	}

	@Override
	public void provideFeedback(FeedbackDTO feedbackDTO) {
		interviewRepository.provideFeedback(feedbackDTO.getInterviewId(), feedbackDTO.getIsSelected(),
				feedbackDTO.getFeedback(), InterviewStatus.COMPLETED.getStatus());
	}
	/**
	 * Retrieve all interviews by interview id.
	 * 
	 * @param interviewId The interviewId to hold interviewId
	 * @return Interview
	 */
	@Override
	public Interview getInterviewById(Long interviewId) {
		return interviewRepository.findById(interviewId).orElse(null);
	}
	/**
	 * Operation to map DTO.
	 * 
	 * @param interviews The interviews to hold list of interviews
	 * @return List of InterviewDTO
	 */
	public List<InterviewDTO> mapListofInterviewTDTO(List<Interview> interviews) {
		List<InterviewDTO> response = new ArrayList<>();
		for (Interview interview : interviews) {
			response.add(mapInterviewToDTO(interview));
		}
		return response;
	}

	/**
	 * Operation to map DTO.
	 *
	 * @param interview The interview to hold interview
	 * @return InterviewDTO
	 */
	InterviewDTO mapInterviewToDTO(Interview interview) {
		InterviewDTO dto = new InterviewDTO();
		dto.setId(interview.getId());
		dto.setInterviewerId(interview.getId());
		dto.setEmployerId(interview.getEmployerId());
		dto.setCandidateName(interview.getCandidateName());
		dto.setFeedback(interview.getFeedback());
		dto.setEmployerNotes(interview.getEmployerNotes());
		dto.setAdminNotes(interview.getAdminNotes());
		dto.setCandidateContact(interview.getCandidateContact());
		dto.setEmail(interview.getEmail());
		dto.setFile(interview.getFile());
		dto.setFileName(interview.getFileName());
		if(interview.getStatus() == InterviewStatus.COMPLETED.getStatus()) {
			dto.setIsSelected(interview.getIsSelected()== 0? "FAIL" : "PASS");
		}
		dto.setInterviewDuration(interview.getInterviewDuration());
		int isSelected = interview.getIsSelected();
		dto.setModeOfInterview(InterviewMode.getNameById(interview.getModeOfInterview()));
		dto.setStatus(InterviewStatus.getStatusNameById(interview.getStatus()));
		dto.setTechnology(SupportedTechnology.getTechnologyById(interview.getTechnology()));
		dto.setRate(interview.getRate());
		dto.setAssigned(interview.getInterviewerId() != null ? true : false);
		dto.setInvoiceGenerated(interview.getInvoiceId() != null ? false : true);
		return dto;
	}
}
