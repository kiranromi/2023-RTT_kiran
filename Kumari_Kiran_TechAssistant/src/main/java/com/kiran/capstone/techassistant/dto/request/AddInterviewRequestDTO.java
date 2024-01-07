package com.kiran.capstone.techassistant.dto.request;

import org.springframework.web.multipart.MultipartFile;

public class AddInterviewRequestDTO {

	private Long employerId;

	private String candidateName;
	
	private String candidateContact;

	private String candidateEmail;

	private int technology;

	private int mode;
	
	private short interviewDuration;

	private String interviewStartAt;

	private String notes;

	private MultipartFile resume;

	public AddInterviewRequestDTO() {
		super();
	}

	public Long getEmployerId() {
		return employerId;
	}

	public MultipartFile getResume() {
		return resume;
	}

	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public short getInterviewDuration() {
		return interviewDuration;
	}

	public void setInterviewDuration(short interviewDuration) {
		this.interviewDuration = interviewDuration;
	}

	public String getInterviewStartAt() {
		return interviewStartAt;
	}

	public void setInterviewStartAt(String interviewStartAt) {
		this.interviewStartAt = interviewStartAt;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateContact() {
		return candidateContact;
	}

	public void setCandidateContact(String candidateContact) {
		this.candidateContact = candidateContact;
	}

	public String getCandidateEmail() {
		return candidateEmail;
	}

	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}

	public int getTechnology() {
		return technology;
	}

	public void setTechnology(int technology) {
		this.technology = technology;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
