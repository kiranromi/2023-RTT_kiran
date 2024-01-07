package com.kiran.capstone.techassistant.dto.request;

public class RegisterRequestDTO {
	private String firstName;
	private String lastName;
	private String employerName;
	private String userName;
	private String password;
	private String confirmPassword;
	private String phoneNumber;
	private String email;
	private int userType;
	private String address;
	private int areaOfSME;

	public RegisterRequestDTO() {
	}

	public RegisterRequestDTO(String firstName, String lastName, String employerName, String userName, String password,
			String confirmPassword, String phoneNumber, String email, int userType, String address, int areaOfSME) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employerName = employerName;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.userType = userType;
		this.address = address;
		this.areaOfSME = areaOfSME;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAreaOfSME() {
		return areaOfSME;
	}

	public void setAreaOfSME(int areaOfSME) {
		this.areaOfSME = areaOfSME;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
