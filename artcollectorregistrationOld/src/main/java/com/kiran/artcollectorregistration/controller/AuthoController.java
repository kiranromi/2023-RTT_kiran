
package com.kiran.artcollectorregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kiran.artcollectorregistration.model.ArtCollector;
import com.kiran.artcollectorregistration.service.ArtCollectorService;

@Controller
public class AuthoController {
	
	private  ArtCollectorService artCollectorService;

    @Autowired
    public void AuthController(ArtCollectorService artCollectorService) {
        this.artCollectorService = artCollectorService;
    }

    // Handler method for art-collectors registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // You may add any necessary model attributes
        return "art-collector-registration";
    }

    // Handler method for art-collectors registration form submit request
    @PostMapping("/register/save")
    public String registerArtCollector(@RequestParam("username") String username,@RequestParam("email") String email,
                                       @RequestParam("password") String password,@RequestParam("country") String country,
                                       Model model) {
        // Create an ArtCollector object and set email and password
        ArtCollector artCollector = new ArtCollector(username,email, password,country);
        // Save the art collector to the database
        artCollectorService.saveArtCollector(artCollector);

        // Redirect to the registration form with a success parameter
        return "redirect:/register?success";
    }

    @GetMapping("/index")
	public String showHomePage(){
		
    		return "index";
    }

    // Handler method for a list of art collectors
    @GetMapping("/artcollectors")
    public String showArtCollectors(Model model) {
        // Retrieve the list of art collectors from the service
        List<ArtCollector> artCollectors = artCollectorService.findAllArtCollector();
        // Add the list to the model
        model.addAttribute("artCollectors", artCollectors);

        // Return the view for displaying registered art collectors
        return "registered-art-collectors";
    }

    // Handler method for logging in
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";

}
}
   
