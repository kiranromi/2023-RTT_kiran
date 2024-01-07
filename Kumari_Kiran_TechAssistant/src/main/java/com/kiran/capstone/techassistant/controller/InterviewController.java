package com.kiran.capstone.techassistant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiran.capstone.techassistant.config.Authorization;
import com.kiran.capstone.techassistant.config.UserSessionHandler;
import com.kiran.capstone.techassistant.constant.UserRole;
import com.kiran.capstone.techassistant.dto.request.AddInterviewRequestDTO;
import com.kiran.capstone.techassistant.dto.request.FeedbackDTO;
import com.kiran.capstone.techassistant.dto.response.InterviewDTO;
import com.kiran.capstone.techassistant.entity.Interview;
import com.kiran.capstone.techassistant.service.InterviewService;

/**
 * Controller class handling operations related to interviews.
 */


@Controller
@RequestMapping("/interviews")
public class InterviewController {

	private final InterviewService interviewService;

	/**
	 * Constructor injection for InterviewController.
	 * 
	 * @param interviewService the InterviewService
	 */
	public InterviewController(InterviewService interviewService) {
		this.interviewService = interviewService;
	}
	/**
	 * Retrieves all interviews for administrators.
	 * 
	 * @param model The model to hold the interviews.
	 */
	@Authorization(roles = { "ADMIN" })
	@GetMapping("/all")
	public void getAllInterviews(Model model) {
		model.addAttribute("interviews", interviewService.getAllInterviews());
	}
	
	/**
	 * Retrieves all the active interviews for administrators.
	 * 
	 * @param model The model to hold the interviews.
	 */

	@Authorization(roles = { "ADMIN" })
	@GetMapping("/active")
	public void getAllActiveInterviews(Model model) {
		model.addAttribute("interviews", interviewService.getAllActiveInterviews());
	}
	/**
	 * Retrieve interview assignment page by administrators.
	 * 
	 * @param model The model to hold the interviews.
	 * @param httpRequest The httpRequest to hold request
	 * @return assign-interview page
	 */
	@GetMapping("/assign/")
	@Authorization(roles = { "ADMIN" })
	public String assignInterviewModel(Model model, HttpServletRequest httpRequest) {
		model.addAttribute("interviewId", httpRequest.getParameter("interviewId"));
		return "assign-interview";
	}
	/**
	 * Assign interview to Interviewer by administrators.
	 * 
	 * @param model The model to hold the interviews.
	 * @param httpRequest The httpRequest to hold request
	 * @return admin-dashboard page
	 */
	@PostMapping("/assignInterview/")
	@Authorization(roles = { "ADMIN" })
	public String assignInterview(Model model, HttpServletRequest httpRequest) {
		Long interviewId = Long.parseLong(httpRequest.getParameter("interviewId"));
		Long interviewerId = Long.parseLong(httpRequest.getParameter("interviewerId"));
		interviewService.assignInterview(interviewerId, interviewId);
		model.addAttribute("interviewList", interviewService.getAllInterviews());
		return "admin-dashboard";
	}
	
	/**
	 * Retrieve all active interview by user id.
	 * 
	 * @param model The model to hold the interviews.
	 * @param userType The userType to hold type of user
	 * @param userId The userId to hold userId
	 * @return interviews
	 */

	@GetMapping("/{userType}/{userId}/active")
	public String getAllActiveInterviewsByUserId(Model model, @PathVariable("userType") String userType,
			@PathVariable("userId") long userId) throws Exception {
		model.addAttribute("interviews", interviewService.getAllActiveInterviewsByUserId(userType, 23));
		return "interviews";
	}

	/**
	 * Retrieve all interviews for administrators.
	 *  
	 * @return interviews
	 */
	
	@Authorization(roles = { "ADMIN" })
	@GetMapping("/allInterviews")
	public ResponseEntity<List<InterviewDTO>> getInterviewList() throws Exception {
		List<InterviewDTO> list = interviewService.getAllInterviews();
		list.stream().forEach(i -> i.setFile(null));
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(list);
	}
	
	/**
	 * Get Add Interview request page by employer.
	 *  
	 * @return view employer request page
	 */

	@Authorization(roles = { "EMPLOYER" })
	@GetMapping("/")
	public String addInterview(Model model) {
		model.addAttribute("requestDTO", new AddInterviewRequestDTO());
		return "employeer-request-interview";
	}

	/**
	 * Add Interview request by employer.
	 *  
	 * @param model The model to hold the interview request.
	 * @param interviewRequestDTO The interviewRequestDTO
	 * @param httpRequest The httpRequest to hold request
	 * @return employer dashboard page
	 */
	@Authorization(roles = { "EMPLOYER" })
	@PostMapping("/")
	public String addInterview(Model model,
			@ModelAttribute("inerviewDetails") AddInterviewRequestDTO interviewRequestDTO,
			HttpServletRequest httpRequest) throws IOException {
		Long userId = UserSessionHandler.getUserIdByToken((String) httpRequest.getParameter("authorization"));
		interviewRequestDTO.setEmployerId(userId);
		interviewService.addInterview(interviewRequestDTO);
		model.addAttribute("interviewList",
				interviewService.getAllInterviewsByUserId(UserRole.EMPLOYER.getType(), userId));
		return "employer-dashboard";
	}

	/**
	 * Handle Get request to get interviewer feedback page.
	 *  
	 * @param model The model to hold the interview feedback.
	 * @param httpRequest The httpRequest to hold request
	 * @return view page
	 */

	@Authorization(roles = { "INTERVIEWER" })
	@GetMapping("/feedback")
	public String provideFeedbackModel(Model model, HttpServletRequest httpRequest) {
		model.addAttribute("feedbackDTO", new FeedbackDTO());
		model.addAttribute("interviewId", httpRequest.getParameter("interviewId"));
		return "/interview-feedback";
	}
	/**
	 * Handle POST request to process interviewer feedback.
	 *  
	 * @param model The model to hold the interview feedback.
	 * @param feedbackDTO The feedbackDTO to hold DTO
	 * @param httpRequest The httpRequest to hold request
	 * @return interviewer dashboard page
	 */
	@Authorization(roles = { "INTERVIEWER" })
	@PostMapping("/feedback")
	public String provideFeedback(Model model, @ModelAttribute("feedback") FeedbackDTO feedbackDTO,
			HttpServletRequest httpRequest) {
		interviewService.provideFeedback(feedbackDTO);
		Long userId = UserSessionHandler.getUserIdByToken(httpRequest.getParameter("authorization"));
		model.addAttribute("interviewList",
				interviewService.getAllInterviewsByUserId(UserRole.INTERVIEWER.getType(), userId));
		return "interviewer-dashboard";
	}

	/**
	 * Handle Get request to get download resume.
	 *  
	 * @param model The model to hold the interview feedback.
	 * @param interviewId The path variable to hold interviewId
	 * @return view page
	 */
	@GetMapping("/{interviewId}/downloadResume")
	public ResponseEntity<Resource> downloadResume(@PathVariable String interviewId) {
		// Retrieve the resume from the database by ID
		Interview interview = interviewService.getInterviewById(Long.parseLong(interviewId));

		// Return a ResponseEntity with the resume data
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + interview.getFileName())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(new ByteArrayResource(interview.getFile()));
	}

	/**
	 * Handle Get request to get all supported technologies.
	 * @param model The model to hold data
	 * @return interviews
	 */
	@GetMapping("/technologies")
	public String getSupportedTechnologies(Model model) {
		model.addAttribute("technologies", interviewService.getSupportedTechnologiesList());
		return "interviews";
	}

}
