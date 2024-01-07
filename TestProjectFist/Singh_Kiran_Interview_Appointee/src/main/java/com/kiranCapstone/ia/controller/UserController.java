package com.kiranCapstone.ia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiranCapstone.ia.entity.InterviewerDetails;
import com.kiranCapstone.ia.service.UserService;
import com.kiranCapstone.ia.service.interviewerDetailsService;

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	private interviewerDetailsService interviewerDetailsService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/")
	public String listAllUser(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}

	@GetMapping("/interviewers")
	public String getListOfInterviewers(Model model) {
		model.addAttribute("interviewers_detail", userService.getListOfInterviewers());
		return "forward:/interviewers";
	}
	
	@PostMapping("/interviewerDetails")
	public String updateInterviewDetails(@ModelAttribute("user") InterviewerDetails interviewerDetails){
		interviewerDetailsService.updateInterviewDetails(interviewerDetails);
		return "redirect:/users";
	}
	
	@GetMapping("/employers")
	public String getListOfEmployers(Model model) {
		model.addAttribute("employers_detail", userService.getListOfEmployers());
		return "forward:/employers";
	}
}
