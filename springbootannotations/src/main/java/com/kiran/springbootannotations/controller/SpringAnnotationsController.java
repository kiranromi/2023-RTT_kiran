package com.kiran.springbootannotations.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kiran.springbootannotations.model.Course;

@Controller
@RequestMapping("/home")
public class SpringAnnotationsController {
	
	@GetMapping("/login")
  public String getLoginPage() {
	  return "login";
  }
	@GetMapping("/index")
	public String getrIndexPage() {
		return "index";
	}

 public String showCourse(@RequestParam("id") int Id,@RequestParam("course") String course, @RequestParam("instructor")String instructor,Model model) {
Course courseobj = new Course(Id,course,instructor);
model.addAttribute("courseAtt", courseobj);
 return "showCourse";
 }

 @GetMapping("/books/{ISBN}/{NAME}")
 public String showBookDetails(@PathVariable("ISBN")String id,@PathVariable("NAME")String name, Model model) {

  model.addAttribute("ISBNAttribute", id);
  model.addAttribute("NameAttr", name);
  model.addAttribute("NameAttr", name);
  
  return "bookDetails";
  
 
}
 @ModelAttribute("countries")
 public List<String>getCountries(){
	 List <String>countries = new ArrayList<>();
	 countries.add("USA");
	 countries.add("UK");
	 countries.add("France");
	 return countries;
 }
 @ModelAttribute
 public void getStates(Model model) {
	 
	 List<String>states = new ArrayList<>();
	 states.add("California");
	 states.add("New York");
	 states.add("Alaska");
	 states.add("Colorado");
	 model.addAttribute("states", states);
 }
 @GetMapping("/myhome")
 public String home(@ModelAttribute("countries") List<String> countries, Model model) {
	 countries.add("Switzerland");
	 countries.add("Canada");
	 return "home";
	 
 }
 
}