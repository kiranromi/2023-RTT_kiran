package com.kiranCapstone.ia.dto.request;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class AddInterviewRequestDTO {

	@NotNull
	private Long employerId;

	private short interviewDuration;

	private String interviewStartAt;

	@NotNull
	private String candidateName;

	@NotNull
	private Long candidateContact;

	private int yearOfExp;

	@NotNull
	private String areaOfSME;
	
	@NotNull
	private MultipartFile file;
	

	public AddInterviewRequestDTO() {
		super();
	}

public AddInterviewRequestDTO(Long employerId, short interviewDuration, String interviewStartAt,
			String candidateName, Long candidateContact, int yearOfExp, String areaOfSME, MultipartFile file) {
		super();
		this.employerId = employerId;
		this.interviewDuration = interviewDuration;
		this.interviewStartAt = interviewStartAt;
		this.candidateName = candidateName;
		this.candidateContact = candidateContact;
		this.yearOfExp = yearOfExp;
		this.areaOfSME = areaOfSME;
		this.file = file;
	}

//	public AddInterviewRequestDTO(Long employerId, short interviewDuration, String interviewStartAt,
//			String candidateName, Long candidateContact, int yearOfExp, String areaOfSME) {
//		super();
//		this.employerId = employerId;
//		this.interviewDuration = interviewDuration;
//		this.interviewStartAt = interviewStartAt;
//		this.candidateName = candidateName;
//		this.candidateContact = candidateContact;
//		this.yearOfExp = yearOfExp;
//		this.areaOfSME = areaOfSME;
//	}

	public Long getEmployerId() {
		return employerId;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
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

	public Long getCandidateContact() {
		return candidateContact;
	}

	public void setCandidateContact(Long candidateContact) {
		this.candidateContact = candidateContact;
	}

	public int getYearOfExp() {
		return yearOfExp;
	}

	public void setYearOfExp(int yearOfExp) {
		this.yearOfExp = yearOfExp;
	}

	public String getAreaOfSME() {
		return areaOfSME;
	}

	public void setAreaOfSME(String areaOfSME) {
		this.areaOfSME = areaOfSME;
	}

}
