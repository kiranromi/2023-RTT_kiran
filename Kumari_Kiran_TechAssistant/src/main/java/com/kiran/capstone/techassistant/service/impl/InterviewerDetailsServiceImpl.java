package com.kiran.capstone.techassistant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kiran.capstone.techassistant.entity.InterviewerDetails;
import com.kiran.capstone.techassistant.repository.InterviewDetailsRepository;
import com.kiran.capstone.techassistant.service.interviewerDetailsService;

/**
 * Service implementation class to handle update Interviewer Details.
 */
public class InterviewerDetailsServiceImpl implements interviewerDetailsService {


	@Autowired
	private InterviewDetailsRepository detailsRepository;
    
	/**
	 * Operation to update Interviewer Details.
	 * 
	 * @param interviewerDetails The interviewerDetails parameter to hold the interviewerDetails.
	 * @return interviewerDetails.
	 */
	@Override
	public InterviewerDetails updateInterviewDetails(InterviewerDetails interviewerDetails) {
		return detailsRepository.save(interviewerDetails);
		
	}
}
