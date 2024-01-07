package com.kiranCapstone.ia.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "interview_id", nullable = false)
	private Long interviewId;

	@Column(name = "interviewer_id", nullable = false)
	private Long interviewerId;

	@Column(name = "employer_id", nullable = false)
	private Long employerId;

	@Column(name = "generated_by", nullable = true)
	private Long generatedBy;

	@Column(name = "rate", nullable = false)
	private int amount;

	@Column(name = "generated_at", nullable = false)
	private LocalDateTime generatedAt;

	@Column(name = "due_date", nullable = true)
	private LocalDateTime dueDate;

	public Invoice() {
		super();
	}

	public Invoice(Long id, Long interviewId, Long interviewrId, Long employerId, Long generatedBy, int amount,
			LocalDateTime generatedAt, LocalDateTime dueDate) {
		super();
		this.id = id;
		this.interviewId = interviewId;
		this.interviewerId = interviewrId;
		this.employerId = employerId;
		this.generatedBy = generatedBy;
		this.amount = amount;
		this.generatedAt = generatedAt;
		this.dueDate = dueDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmployerId() {
		return this.employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public Long getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Long interviewId) {
		this.interviewId = interviewId;
	}

	public Long getInterviewrId() {
		return interviewerId;
	}

	public void setInterviewrId(Long interviewrId) {
		this.interviewerId = interviewrId;
	}

	public Long getGeneratedBy() {
		return generatedBy;
	}

	public void setGeneratedBy(Long generatedBy) {
		this.generatedBy = generatedBy;
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

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

}
