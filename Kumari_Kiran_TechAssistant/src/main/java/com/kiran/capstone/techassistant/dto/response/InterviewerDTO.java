package com.kiran.capstone.techassistant.dto.response;

public class InterviewerDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private int areaOfSME;

	public InterviewerDTO() {
		super();
	}

	public InterviewerDTO(Long id, String firstName, String lastName, String email, String phone, int areaOfSME) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.areaOfSME = areaOfSME;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAreaOfSME() {
		return areaOfSME;
	}

	public void setAreaOfSME(int areaOfSME) {
		this.areaOfSME = areaOfSME;
	}

}