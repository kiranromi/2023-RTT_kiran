package com.kiran.capstone.techassistant.dto.response;

public class InterviewDTO {

	private Long id;

	private Long employerId;

	private String employerName;
		
	private Long interviewerId;

	private String candidateName;

	private String candidateContact;

	private String technology;

	private String email;

	private String modeOfInterview;

	private short interviewDuration;

	private String status;
	private String isSelected;

	private String feedback;
	private String employerNotes;
	private String adminNotes;
	private boolean isAssigned;
	private boolean invoiceGenerated;

	private int rate;

	private String fileName;

	private byte[] file;

	public InterviewDTO() {
		super();
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

	public short getInterviewDuration() {
		return interviewDuration;
	}

	public void setInterviewDuration(short interviewDuration) {
		this.interviewDuration = interviewDuration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(String isSelected) {
		this.isSelected = isSelected;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
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

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getModeOfInterview() {
		return modeOfInterview;
	}

	public void setModeOfInterview(String modeOfInterview) {
		this.modeOfInterview = modeOfInterview;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getEmployerNotes() {
		return employerNotes;
	}

	public void setEmployerNotes(String employerNotes) {
		this.employerNotes = employerNotes;
	}

	public String getAdminNotes() {
		return adminNotes;
	}

	public void setAdminNotes(String adminNotes) {
		this.adminNotes = adminNotes;
	}

	public boolean isAssigned() {
		return isAssigned;
	}

	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}

	public boolean isInvoiceGenerated() {
		return invoiceGenerated;
	}

	public void setInvoiceGenerated(boolean invoiceGenerated) {
		this.invoiceGenerated = invoiceGenerated;
	}

}
