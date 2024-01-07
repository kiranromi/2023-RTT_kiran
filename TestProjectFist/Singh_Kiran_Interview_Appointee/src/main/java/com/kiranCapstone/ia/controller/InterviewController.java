package com.kiranCapstone.ia.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiranCapstone.ia.dto.request.AddInterviewRequestDTO;
import com.kiranCapstone.ia.dto.request.FeedbackDTO;
import com.kiranCapstone.ia.entity.Resume;
import com.kiranCapstone.ia.service.InterviewService;

@Controller
@RequestMapping("/interviews")
public class InterviewController {

	private final InterviewService interviewService;

	public InterviewController(InterviewService interviewService) {
		this.interviewService = interviewService;
	}


	@GetMapping("/all")
	public void getAllInterviews(Model model) {
		model.addAttribute("interviews", interviewService.getAllInterviews());
	}

	@GetMapping("/active")
	public void getAllActiveInterviews(Model model) {
		model.addAttribute("interviews", interviewService.getAllActiveInterviews());
	}
	
	@GetMapping("/{userType}/{userId}/active")
	public String getAllActiveInterviewsByUserId(Model model, @PathVariable("userType") String userType,
			@PathVariable("userId") long userId) throws Exception {
		model.addAttribute("interviews", interviewService.getAllActiveInterviewsByUserId(userType, 23));
		return "interviews";
	}

	/////////////////// ********************************////////////////////////

	@PostMapping("/")
	public String addInterview(@ModelAttribute("inerviewDetails") AddInterviewRequestDTO interviewRequestDTO) {
		interviewService.addInterview(interviewRequestDTO);
		return "redirect:/interviews";
	}

	@PutMapping("/{interviewId}/assign/{interviewerId}")
	public String assignInterview(Model model, @PathVariable("interviewerId") long interviewerId,
			@PathVariable("interviewId") long interviewId) {
		interviewService.assignInterview(interviewerId, interviewId);
		return "redirect:/interviews";
	}

	@PutMapping("/{interviewId}/decline")
	public String declineInterview(Model model, @PathVariable("interviewId") long interviewId) {
		interviewService.declineInterview(interviewId);
		return "redirect:/interviews";
	}

	@PutMapping("/feedback")
	public String provideFeedback(Model model, @ModelAttribute("feedback")  FeedbackDTO feedbackDTO) {
		interviewService.provideFeedback(feedbackDTO);
		return "redirect:/interviews";
	}
	///////////////////////////// *******************//////////////////////

	@GetMapping("/upload-form")
	public String showUploadForm() {
		return "upload-form";
	}

	@GetMapping("/{resumeId}/download")
	public ResponseEntity<Resource> downloadResume(@PathVariable Long resumeId) {
		// Retrieve the resume from the database by ID
		Resume resume = interviewService.getResumeById(resumeId);

		// Return a ResponseEntity with the resume data
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resume.getFileName())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(new ByteArrayResource(resume.getFile()));
	}

	//////////////////////// ************************///////////////////////////
	@GetMapping("/technologies")
	public String getSupportedTechnologies(Model model) {
		model.addAttribute("technologies", interviewService.getSupportedTechnologiesList());
		return "interviews";
	}

	@GetMapping("/{technology}/users")
	public String getInterviewersByTechnology(Model model, @PathVariable("technology") String technology) {
		model.addAttribute("interviewers", interviewService.getInterviewersByTechnology(technology));
		return "wcwwc";
	}
}
