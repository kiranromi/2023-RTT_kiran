package com.kiran.capstone.techassistant.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * class holds constant interview mode values in enum.
 */
public enum InterviewMode {

	IN_PERSON(1, "In person"), PHONE(2, "Phone"), ONLINE(3, "Online");

	int id;
	String name;

	private static Map<Integer,String> nameById = new HashMap<Integer, String>();
	
	static {
		for(InterviewMode mode : InterviewMode.values()) {
			nameById.put(mode.getId(),mode.name);
		}
	}
	
	InterviewMode(int id, String name) {
		this.name = name;
		this.id=  id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static String getNameById(Integer id) {
		return nameById.get(id);
	}
	
}
