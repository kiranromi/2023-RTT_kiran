package com.kiranCapstone.ia.dto.response;

public class InterviewerDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String areaOfSME;
	private int yearOfExperiance;

	public InterviewerDTO() {
		super();
	}

	public InterviewerDTO(Long id, String firstName, String lastName, String email, String areaOfSME,
			int yearOfExperiance) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.areaOfSME = areaOfSME;
		this.yearOfExperiance = yearOfExperiance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}