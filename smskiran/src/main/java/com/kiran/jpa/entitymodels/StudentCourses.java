package com.kiran.jpa.entitymodels;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Harry
 *
 */
@Entity
@Table( name="student_course")
public class StudentCourses implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="email")
	private String email;
	@Id
	@Column(name="course_id")
	private int courseID;

	
	public StudentCourses() {}
	
	/**
	 * @param eMail
	 * @param courseID
	 */
	public StudentCourses(String eMail, int courseID) {
		this.email = eMail;
		this.courseID = courseID;
	}

	
	/**
	 * @return the eMail
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the courseID
	 */
	public int getCourseID() {
		return courseID;
	}

	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseID;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCourses other = (StudentCourses) obj;
		if (courseID != other.courseID)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

}

