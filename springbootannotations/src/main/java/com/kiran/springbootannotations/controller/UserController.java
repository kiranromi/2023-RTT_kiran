package com.kiran.springbootannotations.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.kiran.springbootannotations.model.User;

public class UserController {
	@ModelAttribute("countries")
	public List < String > getUserCountries() {
		List < String > countries = new ArrayList < > ();
		countries.add("UK");
		countries.add("USA");
		countries.add("Japan");
		return countries;
		}
	@ModelAttribute
	public void getUsers (Model model)
	{
	User u1 = new User(1,"haseeb","haseeb@gmail.com");
	User u2 = new User(2,"Josph","Josph@gmail.com");
	User u3 = new User(3,"Ameer","Ameer@gmail.com");
	List < User> myuser = new ArrayList < > ();
	myuser.add(u1);
	myuser.add(u2);
	myuser.add(u3);
	model.addAttribute("myuserAttribute", myuser);
	}
	
	
	@GetMapping("/Home")
	public String home(@ModelAttribute("countries") List < String >
	countries,Model model) {
	//Adding more countries
	countries.add("Australia");
	countries.add("Canada");
	return "Home";
	}

