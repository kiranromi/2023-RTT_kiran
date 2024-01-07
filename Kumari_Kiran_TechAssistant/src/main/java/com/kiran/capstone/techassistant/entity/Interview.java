package com.kiran.capstone.techassistant.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Interview")
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "employer_id", nullable = false)
	private Long employerId;

	@Column(name = "interviewer_id", nullable = true)
	private Long interviewerId;

	@Column(name = "candidate_Name", nullable = true)
	private String candidateName;

	@Column(name = "candiate_contact", nullable = true)
	private String candidateContact;

	@Column(name = "technology", nullable = true)
	private int technology;

	@Column(name = "email", nullable = true)
	private String email;

	@Column(name = "mode_Of_Interview", nullable = true)
	private int modeOfInterview;

	@Column(name = "interview_duration", nullable = true)
	private short interviewDuration;

	@Column(name = "interview_start_at", nullable = true)
	private LocalDateTime interviewStartAt;

	@Column(name = "status", nullable = false)
	private int status;

	@Column(name = "feedback", nullable = true)
	private String feedback;

	@Column(name = "employerNotes", nullable = true)
	private String employerNotes;

	@Column(name = "adminNotes", nullable = true)
	private String adminNotes;

	@Column(name = "is_selected", nullable = true)
	private int isSelected;

	@Column(name = "rate", nullable = false)
	private int rate;

	@Column(name = "file_name", nullable = false)
	private String fileName;
	
	@Column(name = "invoice_id", nullable = true)
    private Long invoiceId;

	@Lob
	@Column(name = "file", nullable = false, columnDefinition = "LONGBLOB")
	private byte[] file;

	public Interview() {
		super();
	}

	public Interview(Long id, Long employerId, Long interviewerId, String candidateName, String candidateContact,
			int technology, String email, int modeOfInterview, short interviewDuration, LocalDateTime interviewStartAt,
			int status, String feedback, String employerNotes, String adminNotes, int isSelected, int rate,
			String fileName, byte[] file, Long invoiceId) {
		super();
		this.id = id;
		this.employerId = employerId;
		this.interviewerId = interviewerId;
		this.candidateName = candidateName;
		this.candidateContact = candidateContact;
		this.technology = technology;
		this.email = email;
		this.modeOfInterview = modeOfInterview;
		this.interviewDuration = interviewDuration;
		this.interviewStartAt = interviewStartAt;
		this.status = status;
		this.feedback = feedback;
		this.employerNotes = employerNotes;
		this.adminNotes = adminNotes;
		this.isSelected = isSelected;
		this.rate = rate;
		this.fileName = fileName;
		this.file = file;
		this.invoiceId = invoiceId;
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

	public short getInterviewDuration() {
		return interviewDuration;
	}

	public void setInterviewDuration(short interviewDuration) {
		this.interviewDuration = interviewDuration;
	}

	public LocalDateTime getInterviewStartAt() {
		return interviewStartAt;
	}

	public void setInterviewStartAt(LocalDateTime interviewStartAt) {
		this.interviewStartAt = interviewStartAt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(int isSelected) {
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

	public int getTechnology() {
		return technology;
	}

	public void setTechnology(int technology) {
		this.technology = technology;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getModeOfInterview() {
		return modeOfInterview;
	}

	public void setModeOfInterview(int modeOfInterview) {
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

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

}
