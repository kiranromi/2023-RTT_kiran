package com.kiranCapstone.ia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kiranCapstone.ia.entity.InterviewerDetails;
import com.kiranCapstone.ia.repository.InterviewDetailsRepository;
import com.kiranCapstone.ia.service.interviewerDetailsService;

public class InterviewerDetailsServiceImpl implements interviewerDetailsService {


	@Autowired
	private InterviewDetailsRepository detailsRepository;

	@Override
	public InterviewerDetails updateInterviewDetails(InterviewerDetails interviewerDetails) {
		return detailsRepository.save(interviewerDetails);
		
	}
}
