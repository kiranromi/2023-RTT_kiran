package com.kiranCapstone.ia.constant;

public enum InterviewStatus {

	 ACTIVE(1), COMPLETED(2), DECLINED(3), INACTIVE(4);

	private int status;

	InterviewStatus(int i) {
		this.status = i;
	}

	public int getStatus() {
		return status;
	}
}
