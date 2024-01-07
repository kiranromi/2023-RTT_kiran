package com.kiran.springbootannotations.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kiran.springbootannotations.model.User;

@Controller
public class ModelAndViewController {
	@GetMapping("/showViewPage")
	public String passParametersWithModel(Model model) {
	model.addAttribute("message", "Perscholas");
	model.addAttribute("welcomeMessage", "welcome");
	int i = 10;
	model.addAttribute("number", i);
	List<String> list = Arrays.asList("one", "two");
	model.addAttribute("listData", list);
	return "viewPage";

}
	@GetMapping("/goToViewPage")
	public ModelAndView passParametersWithModelAndView() {
		String st = "Welcome to the Page";
		ModelAndView modelAndView = new ModelAndView("viewPage_2");
		modelAndView.addObject("message", st);
		modelAndView.addObject("info", "Employee information.");
		return modelAndView;
}
	@GetMapping("/goToUserViewPage")
	public ModelAndView UserModelAndView() {
	List<User> listUsers = new ArrayList<User>();
	listUsers.add(new User(1,"Haseeb","haseeb@abc.com,"));
	listUsers.add(new User(2,"Shahparan","Shahparan@abc.com,"));
	listUsers.add(new User(3,"James","James@abc.com,"));
	listUsers.add(new User(4,"Joseph","Joseph@abc.com,"));
	ModelAndView modelAndView = new ModelAndView("userdata");
	modelAndView.addObject("userlist", listUsers);
	return modelAndView;
}
}
	