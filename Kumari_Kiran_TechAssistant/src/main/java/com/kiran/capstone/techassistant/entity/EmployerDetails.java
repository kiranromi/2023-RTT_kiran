package com.kiran.capstone.techassistant.entity;

import javax.persistence.Column;

//@Entity
//@Table(name = "Employer_Details")
public class EmployerDetails {

	@Column(name = "employer_id", nullable = false)
	private Long employerId;

	@Column(name = "employer_name", nullable = false)
	private String employerName;

	public EmployerDetails() {
		super();
	}

	public EmployerDetails(Long employerId, String employerName) {
		super();
		this.employerId = employerId;
		this.employerName = employerName;
	}

	public Long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

}
