package com.kiran.jpa.entitymodels;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	/*
	 * @Column(name = "ID")
	 * 
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * private Integer id;
	 * 
	 * @Column(name = "email", unique = true, nullable = false)
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "email")	
	private String sEmail;
	@Column(name = "name")
	private String sName;	
	@Column(name = "password")
	private String sPass;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "email"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> sCourses;

	public Student(){

		this.sEmail = "";
		this.sName =""; 
		this.sPass = "";
		this.sCourses = null;
	}

	public Student(String sEmail, String sFullname, String sPassword, List<Course> sCourse) {
		super();
		this.sEmail = sEmail;
		this.sName = sFullname;
		this.sPass = sPassword;
		this.sCourses = sCourse;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsFullname() {
		return sName;
	}

	public void setsFullname(String sFullname) {
		this.sName = sFullname;
	}

	public String getsPassword() {
		return sPass;
	}

	public void setsPassword(String sPassword) {
		this.sPass = sPassword;
	}

	public List<Course> getsCourse() {
		return sCourses;
	}

	public void setsCourse(List<Course> sCourse) {
		this.sCourses = sCourse;
	}

	@Override
	public String toString() {
		return "Student [sEmail=" + sEmail + ", sFullname=" + sName + ", sPassword=" + sPass + "]";
	}





}







