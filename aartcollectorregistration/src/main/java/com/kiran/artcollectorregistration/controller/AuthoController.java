package com.kiran.artcollectorregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kiran.artcollectorregistration.model.ArtCollector;
import com.kiran.artcollectorregistration.service.ArtCollectorService;

import jakarta.validation.Valid;

@Controller
public class AuthoController {

	private ArtCollectorService artCollectorService;

	@Autowired
	public AuthoController(ArtCollectorService artCollectorService) {
		this.artCollectorService = artCollectorService;
	}
	@GetMapping("/index")
	public String home() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		ArtCollector collector = new ArtCollector();
		model.addAttribute("Collector", collector);
		return "artcollectorregistration";
	}
	
	/*
	It takes an ArtCollector object annotated with @Valid for validation, 
	a BindingResult for handling validation errors, and a Model for adding attributes to the model.*/
	
	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("Collector") ArtCollector collector, BindingResult result,
			Model model)
			
	{
		ArtCollector existingCollector = artCollectorService.findArtCollectorByEmail(collector.getEmail()); // Checking for Existing Collector
	
		//if email is already available in db
		/*We are checking if there's already an ArtCollector with the same email address.
		If an existing collector is found, you are rejecting the value for the "email" field
		 in the validation result with a custom error message.*/
		
		if (existingCollector != null && existingCollector.getEmail() != null && !existingCollector.getEmail().isEmpty()) {
			result.rejectValue("email", null, "There is already an account registered with the same email");
		}
		if (result.hasErrors()) {   // Handling Validation Error
			model.addAttribute("Collector", collector);		
		return "/artcollectorregistration";
		}
				
		
		//if email is Not already available in db
		//Calling service class 
		artCollectorService.saveArtCollector(collector);
		
		//After saving in db or successful registration redirect to success
		return "redirect:/register?success";   
}
	
	/*If there are validation errors, We are adding the ArtCollector object and returning to the "/artcollectorregistration" page.
	The Collector attribute is added to the model  line 74 so that the form can pre-fill with the user's previous input.*/
	
	
	@GetMapping("/artcollectors")
	public String collector(Model model) {
		List<ArtCollector> collectors = artCollectorService.findAllArtCollector();

		model.addAttribute("collector", collectors);

		return "registeredartcollector";

	}


}
