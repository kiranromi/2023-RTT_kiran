package com.kiran.capstone.techassistant.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * class holds constant Supported Technology values in enum.
 */
public enum SupportedTechnology {

	JAVA(1,"JAVA/J2EE", 50,70,100), 
	DOTNET(2,"Microsoft Technoligies", 60, 90,100), 
	FullStack(3, "FullStack Developer", 70, 100,100), 
	DB(4, "Database Developer", 50, 80,100), 
	DB_ADMIN(5, "Database Administrator", 50, 80,100), 
	FRONTEND(6, "FrontEnd", 50, 70,100), 
	DEVOPS(7, "DevOps", 50, 80,100),
	CLOUD(8, "Cloud Technologies", 80, 100,100),
	GO(9, "GO", 80, 100,100), 
	SCRUM_MASTER(10," Scrum Master", 70, 100,100),
	PYTHON(11, "PYTHON", 50, 60,100);

	int id;
	String name;
	int rateForOnlineInterview;
	int rateForInpersonInterview;
	int rateForTelephonicInterview;

	private static final Map<Integer, Integer> onlineInvoiceAmountByName = new HashMap<>();
	private static final Map<Integer, Integer> inpersonInterviewAmountByName = new HashMap<>();
	private static final Map<Integer, String> technologyById = new HashMap<>();
	static {
		for (SupportedTechnology technology : SupportedTechnology.values()) {
			onlineInvoiceAmountByName.put(technology.getId(), technology.getRateForOnlineInterview());
			inpersonInterviewAmountByName.put(technology.getId(), technology.getRateForInpersonInterview());
			technologyById.put(technology.getId(), technology.name());
		}
	}

	private SupportedTechnology(int id, String name, int rateForOnlineInterview, int rateForInpersonInterview, int rateForTelephonicInterview) {
		this.id = id;
		this.name = name;
		this.rateForOnlineInterview = rateForOnlineInterview;
		this.rateForInpersonInterview = rateForInpersonInterview;
		this.rateForTelephonicInterview = rateForTelephonicInterview;
	}

	public static Integer getOnlineInvoiceAmountbyname(int id) {
		return onlineInvoiceAmountByName.get(id);
	}

	public static Integer getInpersonInterviewAmountbyname(int id) {
		return inpersonInterviewAmountByName.get(id);
	}

	public static String getTechnologyById(int id) {
		return technologyById.get(id);
	}
	
	public static int getInvoiceAmountByIdAndMode(int id, int mode) {
		if (mode == InterviewMode.IN_PERSON.getId()) {
			return inpersonInterviewAmountByName.get(id);
		} else if (mode == InterviewMode.ONLINE.getId()) {
			return onlineInvoiceAmountByName.get(id);
		} else {
			return 0;
		}
	}
	
	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getRateForOnlineInterview() {
		return rateForOnlineInterview;
	}

	public int getRateForInpersonInterview() {
		return rateForInpersonInterview;
	}

	public int getRateForTelephonicInterview() {
		return rateForTelephonicInterview;
	}

	public static Map<Integer, Integer> getOnlineinvoiceamountbyname() {
		return onlineInvoiceAmountByName;
	}

	public static Map<Integer, Integer> getInpersoninterviewamountbyname() {
		return inpersonInterviewAmountByName;
	}

	public static Map<Integer, String> getTechnologybyid() {
		return technologyById;
	}
	
	

}