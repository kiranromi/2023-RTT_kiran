package com.kiran.springbootannotations.model;

public class Course {
	 private int id;
	 private String course;
	 private String instructor;
	 public Course() {}
	public Course(int id, String course, String instructor) {
		super();
		this.id = id;
		this.course = course;
		this.instructor = instructor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", course=" + course + ", instructor=" + instructor + "]";
	}
	 

}
