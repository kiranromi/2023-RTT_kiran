package com.kiran.capstone.techassistant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Interviewer_Details")
public class InterviewerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "interviewer_id", nullable = false)
	private Long interviewerId;

	@Column(name = "area_Of_SME", nullable = false)
	private String areaOfSME;

	@Column(name = "year_of_experiance", nullable = false)
	private int yearOfExperiance;
	
	@Column(name = "rate_per_interview", nullable = false)
	private int ratePerInterview;

	public InterviewerDetails() {
		super();
	}

	public InterviewerDetails(Long id, Long interviewerId, String areaOfSME, int yearOfExperiance, int ratePerInterview) {
		super();
		this.id = id;
		this.interviewerId = interviewerId;
		this.areaOfSME = areaOfSME;
		this.yearOfExperiance = yearOfExperiance;
		this.ratePerInterview = ratePerInterview;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(Long interviewerId) {
		this.interviewerId = interviewerId;
	}

	public String getAreaOfSME() {
		return areaOfSME;
	}

	public void setAreaOfSME(String areaOfSME) {
		this.areaOfSME = areaOfSME;
	}

	public int getYearOfExperiance() {
		return yearOfExperiance;
	}

	public void setYearOfExperiance(int yearOfExperiance) {
		this.yearOfExperiance = yearOfExperiance;
	}

	public int getRatePerInterview() {
		return ratePerInterview;
	}

	public void setRatePerInterview(int ratePerInterview) {
		this.ratePerInterview = ratePerInterview;
	}

}
