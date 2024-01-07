package com.kiran.capstone.techassistant.dto.response;

public class RatesDTO {

	private int id;
	private String name;
	private int onlineRate;
	private int inPersonRate;
	private int phoneRate;

	public RatesDTO() {
		super();
	}

	public RatesDTO(int id,String name, int onlineRate, int inPersonRate, int phoneRate) {
		super();
		this.name = name;
		this.onlineRate = onlineRate;
		this.inPersonRate = inPersonRate;
		this.phoneRate = phoneRate;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOnlineRate() {
		return onlineRate;
	}

	public void setOnlineRate(int onlineRate) {
		this.onlineRate = onlineRate;
	}

	public int getInPersonRate() {
		return inPersonRate;
	}

	public void setInPersonRate(int inPersonRate) {
		this.inPersonRate = inPersonRate;
	}

	public int getPhoneRate() {
		return phoneRate;
	}

	public void setPhoneRate(int phoneRate) {
		this.phoneRate = phoneRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
