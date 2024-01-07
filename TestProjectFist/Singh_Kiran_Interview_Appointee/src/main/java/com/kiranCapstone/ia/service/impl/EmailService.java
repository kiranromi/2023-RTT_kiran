package com.kiranCapstone.ia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${admin.email}")
    private String adminEmail;
	
	public String sendMail(String body, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(adminEmail);
		message.setSubject(subject);
		message.setText(body);
		javaMailSender.send(message);
		return "Email sent successfully!";
	}

}
