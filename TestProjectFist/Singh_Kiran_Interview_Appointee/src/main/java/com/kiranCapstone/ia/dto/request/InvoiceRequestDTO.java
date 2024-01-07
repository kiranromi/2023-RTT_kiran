package com.kiranCapstone.ia.dto.request;

import javax.validation.constraints.NotNull;

public class InvoiceRequestDTO {

	@NotNull
	private Long interviewId;

	private String dueDate;

	public InvoiceRequestDTO() {
		super();
	}

	public InvoiceRequestDTO(@NotNull Long interviewId, String dueDate) {
		super();
		this.interviewId = interviewId;
		this.dueDate = dueDate;
	}

	public Long getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Long interviewId) {
		this.interviewId = interviewId;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

}
