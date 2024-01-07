package com.kiran.capstone.techassistant.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "interview_id", nullable = false)
	private Long interviewId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "interviewer_id", referencedColumnName = "id")
	private User interviewer;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "employer_id", referencedColumnName = "id")
	private User employer;

	@Column(name = "rate", nullable = false)
	private int amount;

	@Column(name = "generated_at", nullable = false)
	private LocalDateTime generatedAt;

	public Invoice() {
		super();
	}

	public Invoice(Long id, Long interviewId, User interviewer, User employer, int amount,
			LocalDateTime generatedAt) {
		super();
		this.id = id;
		this.interviewId = interviewId;
		this.interviewer = interviewer;
		this.employer = employer;
		this.amount = amount;
		this.generatedAt = generatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Long interviewId) {
		this.interviewId = interviewId;
	}

	public User getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(User interviewer) {
		this.interviewer = interviewer;
	}

	public User getEmployer() {
		return employer;
	}

	public void setEmployer(User employer) {
		this.employer = employer;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getGeneratedAt() {
		return amount;
	}

	public void setGeneratedAt(LocalDateTime generatedAt) {
		this.generatedAt = generatedAt;
	}

}
