package com.kiranCapstone.ia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kiranCapstone.ia.dto.request.LoginRequestDTO;
import com.kiranCapstone.ia.dto.request.RegisterRequestDTO;
import com.kiranCapstone.ia.service.UserService;

@Controller
public class HomeController {

	private UserService userService;

	public HomeController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("registerRequestDTO", new RegisterRequestDTO());
		return "register_form";
	}

	@PostMapping("/processRegistration")
	public String processRegistration(@ModelAttribute("registerRequestDTO") RegisterRequestDTO registerRequestDTO) {
		userService.registerUser(registerRequestDTO);
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginRequest", new LoginRequestDTO());
		return "login_form";
	}

	@PostMapping("/processLogin")
	public String processLogin(@ModelAttribute("loginRequest") @Valid LoginRequestDTO loginRequest,
			HttpServletResponse response, Model model, RedirectAttributes attributes) throws Exception {
		
		if (userService.authenticateUser(loginRequest, response)) {
			attributes.addAttribute("authorization", response.getHeader("authorization"));
//			return "redirect:/dashboard";
			return "dashboard";
		} else {
			model.addAttribute("error", "Invalid UserName and Password");
			return "login";
		}
		
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		return "dashboard";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		userService.logout(request.getHeader("authorization"));
		return "redirect:/login";
	}

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
	
//	@RequestMapping("/redirectWithAttribute")
//	public String redirectWithAttribute(RedirectAttributes attributes) {
//	    attributes.addFlashAttribute("key", "value");
//	    return "redirect:/targetPage";
//	}
	
	
}
