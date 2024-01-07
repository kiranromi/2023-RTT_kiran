package com.kiran.capstone.techassistant.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.kiran.capstone.techassistant.service.InterviewService;
import com.kiran.capstone.techassistant.service.UserService;

@ExtendWith(MockitoExtension.class)
public class HomeControllerTest {

	@Mock
	private UserService userService;

	@Mock
	private InterviewService interviewService;

	@InjectMocks
	private HomeController homeController;

	@Test
	public void testHome() {
		Model model = mock(Model.class);

		String viewName = homeController.home(model);

		assertEquals("home", viewName);
	}

	@Test
	public void testAbout() {
		String viewName = homeController.about();

		assertEquals("about", viewName);
	}

	@Test
	public void testContact() {
		String viewName = homeController.contact();

		assertEquals("contact", viewName);
	}

	@Test
	public void testRegisterEmployer() {
		Model model = mock(Model.class);

		String viewName = homeController.registerEmployer(model);

		assertEquals("employer-register", viewName);
	}

	@Test
	public void testRegisterInterviewer() {
		Model model = mock(Model.class);

		String viewName = homeController.registerInterviewer(model);

		assertEquals("interviewer-register", viewName);
	}


}