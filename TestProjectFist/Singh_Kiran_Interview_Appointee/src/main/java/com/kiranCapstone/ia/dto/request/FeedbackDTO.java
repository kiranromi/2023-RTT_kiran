package com.kiranCapstone.ia.dto.request;

public class FeedbackDTO {

	private Long interviewId;
	private String feedback;
	private int isSelected;

	public FeedbackDTO() {
		super();
	}

	public FeedbackDTO(Long interviewId, String feedback, int isSelected) {
		super();
		this.interviewId = interviewId;
		this.feedback = feedback;
		this.isSelected = isSelected;
	}

	public Long getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Long interviewId) {
		this.interviewId = interviewId;
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

}
