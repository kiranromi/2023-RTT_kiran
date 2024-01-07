package com.kiran.capstone.techassistant.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * class holds constant interview status values in enum.
 */
public enum InterviewStatus {

	ACTIVE(1), ASSIGNED(2), COMPLETED(3), DECLINED(4), INACTIVE(5);

	private int status;

	InterviewStatus(int i) {
		this.status = i;
	}

	private static Map<Integer, String> statusNameById = new HashMap<Integer, String>();

	static {
		for (InterviewStatus mode : InterviewStatus.values()) {
			statusNameById.put(mode.getStatus(), mode.name());
		}
	}

	public int getStatus() {
		return status;
	}

	public static String getStatusNameById(Integer id) {
		return statusNameById.get(id);
	}

}
