package com.kiran.springbeans;

public class Student {
 
	private String name;
	private int rollno;
	private String email;
	public Student() {
		super();
}
	public Student(String name, int rollno, String email) {
		super();
		this.name = name;
		this.rollno = rollno;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void display() {
		System.out.println("Name :"+ name);
		System.out.println("Rollno :" +rollno);
		System.out.println("Email :" +email);
				
		
	}
	
	
	

}
