package com.kiran.capstone.techassistant.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiran.capstone.techassistant.config.Authorization;
import com.kiran.capstone.techassistant.dto.response.InterviewerDTO;
import com.kiran.capstone.techassistant.entity.User;
import com.kiran.capstone.techassistant.service.UserService;

/**
 * Controller class handling operations related to Users.
 */

@Controller
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	/**
	 * Constructor injection for UserController.
	 * 
	 * @param userService the userService
	 */
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	/**
	 * Retrieves all users for administrators.
	 * 
	 * @param model The model to hold the interviews.
	 * @return users
	 */
	@Authorization(roles = { "ADMIN" })
	@GetMapping("/")
	public String listAllUser(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}
	/*
	 * Retrieves all interviewers for admin user.
	 * 
	 * @param model The model to hold the interviewer.
	 * @return list of interviewers
	 */
	@Authorization(roles = { "ADMIN" })
	@GetMapping("/interviewers")
	public ResponseEntity<List<InterviewerDTO>> getListOfInterviewers(Model model) {
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(userService.getListOfInterviewers());
	}

	/*
	 * Retrieves all employers for admin user.
	 * 
	 * @param model The model to hold the employers.
	 * @return list of employers
	 */
	@Authorization(roles = { "ADMIN" })
	@GetMapping("/employers")
	public String getListOfEmployers(Model model) {
		model.addAttribute("employers_list", userService.getListOfEmployers());
		return "forward:/employers";
	}
	/*
	 * Retrieves all interviewers based on technology.
	 * 
	 * @param model The model to hold the technology.
	 * @return list of interviewers
	 */

	@GetMapping("/technology/{id}")
	public ResponseEntity<List<User>> getInterviwersBytechnology(HttpServletResponse response, @PathVariable int id) {
		List<User> interviewers = userService.findByAreaOfSME(id);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(interviewers);
	}
}
