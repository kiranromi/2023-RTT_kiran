package com.kiran.springbootannotations.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.springbootannotations.model.Course;



@RestController
@RequestMapping("/myhome")
public class IndexController {
	
	@GetMapping(value={"/index","/login"})
	public String indexMultipleMapping() {
		
		return  "Hello from index multiple mapping";
		
	}
//exposing courses-business- logic
	@GetMapping("/courses")
	public List<Course>retrievAllCourses(){
		return Arrays.asList(
				new Course(2, "Spring Boot MVC", "Professor Lewis"),
				new Course(2, "python Programming", "Professor Smith"),
				new Course(3, "Java  programming", "Professor Johnson")
				);
	}
@GetMapping("/view")
 public String paramWithModel(Model model) {
	model.addAttribute("message", "Good Afternoon Class");
	model.addAttribute("WelcomeMessage", "Welcome");
	model.addAttribute("firstName", "Kiran");
	int i =21;
	model.addAttribute("number", 1);
	List<String>list = Arrays.asList("Apple", "Orange", "Grapes");
	model.addAttribute("listData",list);
	return "viewmessage";
	
}			 
			 
}

