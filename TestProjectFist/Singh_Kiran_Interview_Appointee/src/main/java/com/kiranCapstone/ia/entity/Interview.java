package com.kiranCapstone.ia.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Interview")
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "employer_id", nullable = false)
	private Long employerId;

	@Column(name = "candidate_Name", nullable = false)
	private String candidateName;

	@Column(name = "candiate_contact", nullable = false)
	private Long candidateContact;

	@Column(name = "Year_of_exp", nullable = false)
	private int yearOfExp;

	@Column(name = "area_Of_SME", nullable = false)
	private String areaOfSME;

	@Column(name = "interviewer_id", nullable = true)
	private Long interviewerId;

	@Column(name = "interview_duration", nullable = true)
	private short interviewDuration;

	@Column(name = "interview_start_at", nullable = true)
	private LocalDateTime interviewStartAt;

	@Column(name = "status", nullable = false)
	private int status;

	@Column(name = "feedback", nullable = true)
	private String feedback;

	@Column(name = "is_selected", nullable = true)
	private int isSelected;

	@Column(name = "rate", nullable = false)
	private int rate;

	public Interview() {
		super();
	}

	public Interview(Long id, Long employerId, String candidateName, Long candidateContact, int yearOfExp,
			String areaOfSME, Long interviewerId, short interviewDuration, LocalDateTime interviewStartAt, int status,
			String feedback, int isSelected, int rate) {
		super();
		this.id = id;
		this.employerId = employerId;
		this.candidateName = candidateName;
		this.candidateContact = candidateContact;
		this.yearOfExp = yearOfExp;
		this.areaOfSME = areaOfSME;
		this.interviewerId = interviewerId;
		this.interviewDuration = interviewDuration;
		this.interviewStartAt = interviewStartAt;
		this.status = status;
		this.feedback = feedback;
		this.isSelected = isSelected;
		this.rate = rate;
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
