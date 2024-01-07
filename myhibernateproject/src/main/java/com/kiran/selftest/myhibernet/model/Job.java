package com.kiran.selftest.myhibernet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Job")
public class Job {
	@Column(name = "job_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String name;
	private String company;
	
	public Job() {
		
	}
	
	public Job(Integer id, String name, String company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", name=" + name + ", company=" + company + "]";
	}
	


	

}
