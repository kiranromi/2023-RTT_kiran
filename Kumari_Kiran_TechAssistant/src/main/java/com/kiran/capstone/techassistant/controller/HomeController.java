package com.kiran.capstone.techassistant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kiran.capstone.techassistant.config.UserSessionHandler;
import com.kiran.capstone.techassistant.constant.UserRole;
import com.kiran.capstone.techassistant.dto.request.LoginRequestDTO;
import com.kiran.capstone.techassistant.dto.request.RegisterRequestDTO;
import com.kiran.capstone.techassistant.service.InterviewService;
import com.kiran.capstone.techassistant.service.UserService;

/**
 * The HomeController class handles home page, registration  and login operations.
 * This controller provides endpoints for managing home, aboutus, registerEmployer, registerInterviewer and loginUser.
 */

@Controller
public class HomeController {

	private UserService userService;
	private InterviewService interviewService;

	/**
	 * Constructor injection for HomeController.
	 *
	 * @param userService the userService
	 * @param interviewService the InterviewService
	 */

	public HomeController(UserService userService, InterviewService interviewService) {
		super();
		this.userService = userService;
		this.interviewService = interviewService;
	}

	/**
	 * Handles GET requests to display a home page.
	 */
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("loginRequest", new LoginRequestDTO());
		return "home";
	}
	/**
	 * Handles GET requests to display a aboutus page.
	 */
	@GetMapping("/about")
	public String about() {
		return "about";
	}

	/**
	 * Handles GET requests to display a Contact page.
	 */
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	/**
	 * Handles GET requests to display Employer Registration page.
	 *
	 * @param model the model to add attributes
	 * @return the view name for displaying registered users
	 */

	@GetMapping("/registerEmployer")
	public String registerEmployer(Model model) {
		model.addAttribute("registerRequestDTO", new RegisterRequestDTO());
		return "employer-register";
	}

	/**
	 * Handles GET requests to display Interviewer Registration page.
	 *
	 * @param model the model to add attributes
	 * @return the view name for displaying registered interviewer
	 */

	@GetMapping("/registerInterviewer")
	public String registerInterviewer(Model model) {
		model.addAttribute("registerRequestDTO", new RegisterRequestDTO());
		return "interviewer-register";
	}
	/**
	 * Handles POST requests to process user registration.
	 * Validates the user data, creates a new user using the UserService, and redirects to the home page.
	 *
	 * @param registerRequestDTO the RegisterRequestDTO containing registration data
	 * @return the view name for redirecting to the home page
	 */
	@PostMapping("/processRegistration")
	public String processInterviewerRegistration(@ModelAttribute("registerRequestDTO") RegisterRequestDTO registerRequestDTO) {
		userService.registerUser(registerRequestDTO);
		return "home";
	}
	/**
	 * Handles POST requests to process login.
	 * Validates the input data, authorization, role and redirects role based dashboard page.
	 *
	 * @param model The model to hold the login information.
	 * @param loginRequest the LoginRequestDTO containing login(username, password) data
	 * @return the view name for redirecting to the role based dashboard page
	 */
	@PostMapping("/loginUser")
	public String processLogin(@ModelAttribute("loginRequest") @Valid LoginRequestDTO loginRequest,
			HttpServletResponse response, Model model) throws Exception {

		if (userService.authenticateUser(loginRequest, response)) {
			String role = UserSessionHandler.getRoleByToken(response.getHeader("authorization"));
			Long userId = UserSessionHandler.getUserIdByToken(response.getHeader("authorization"));
			if (role.equalsIgnoreCase(UserRole.INTERVIEWER.name())) {
				model.addAttribute("interviewList",interviewService.getAllInterviewsByUserId(UserRole.INTERVIEWER.getType(), userId));
				model.addAttribute("userName", UserSessionHandler.getUserByToken(response.getHeader("authorization")).getFirstName());
				return "interviewer-dashboard";
			} else if (role.equalsIgnoreCase(UserRole.EMPLOYER.name())) {
				model.addAttribute("interviewList",interviewService.getAllInterviewsByUserId(UserRole.EMPLOYER.getType(),userId));
				model.addAttribute("userName", UserSessionHandler.getUserByToken(response.getHeader("authorization")).getEmployerName());
				return "employer-dashboard";
			} else if (role.equalsIgnoreCase(UserRole.ADMIN.name())) {
				model.addAttribute("interviewList", interviewService.getAllInterviews());
				model.addAttribute("userName", UserSessionHandler.getUserByToken(response.getHeader("authorization")).getFirstName());
				return "admin-dashboard";
			} else {
				model.addAttribute("error", "Invalid Role");
				return "home";
			}
		} else {
			model.addAttribute("error", "Invalid UserName and Password");
			return "home";
		}

	}

	/**
	 * Handles GET requests to logout.
	 */

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		userService.logout(request.getParameter("authorization"));
		return "home";
	}

}
