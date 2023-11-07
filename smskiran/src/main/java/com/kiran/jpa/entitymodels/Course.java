package com.kiran.jpa.entitymodels;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "course")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	// make object integer type instead of primitive id
	@Id		
	@Column(name = "course_id")  // give name to id	
	@GeneratedValue(strategy = GenerationType.IDENTITY) // identity provide primary key
	private Integer cId;
	@Column(name = "name")
	private String cName;
	@Column(name = "instructor")
	private String cInstructorName;

	public Course () {
		this.cId = 0;
		this.cName = "";
		this.cInstructorName = "";
	}

	public Course(Integer cId, String cName, String cInstructorName) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcInstructorName() {
		return cInstructorName;
	}

	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}

	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + ", cInstructorName=" + cInstructorName + "]";
	}







}
