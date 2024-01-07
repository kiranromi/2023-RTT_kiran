package com.kiran.registrationlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiran.registrationlogin.dto.*;

import com.kiran.registrationlogin.dto.UserDTO;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserContoller {
	 @InitBinder
	 public void initBinder(WebDataBinder dataBinder) {
	 StringTrimmerEditor stringTrimmerEditor = new
	 StringTrimmerEditor(true);
	 dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	 }
	 private UserServiceImpl userServiceImpl; 
	 
	 @Autowired
	 public  UserController(UserServiceImpl userServiceImpl ) {
		 this.userServiceImpl = userServiceImpl;
	 }
	 @GetMapping("/")
	 private String redirectToLogin()
	 {
	 return "redirect:/login";
	 }
	 @GetMapping("/sign-up")
	 public String signUp(Model model)
	 {
	 model.addAttribute("userDto", new UserDTO());
	 return "sign-up";
	 }
	 @PostMapping("/signup-process")
	 public String signupProcess(@Valid @ModelAttribute ("userDto") UserDTO
	 userDTO, BindingResult bindingResult)
	 {
	 if(bindingResult.hasErrors())
	 {
	 log.warn("Wrong attempt");
	 return "sign-up";
	 }
	 userServiceImpl.creat(userDTO);
	 return "confirmation";
	 }
	 /**
	 * In order to make code more readable it is good practice to
	 * use special DTOs for login It also make controllers
	 * less dependent from entities and separate validation from
	 * jpa functionality
	 */
	 @GetMapping("/login")
	 public String getLoginPage()
	 {
	 log.info("Login page displayed");
	 return "login";
	 }
	 @GetMapping("/home")
	 public String getHome()
	 {
	 log.info("home page displayed");
	 return "home";
	 }


}
