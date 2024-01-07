package com.kiran.capstone.techassistant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "interview_id", nullable = false)
	private Long interviewId;

	@Column(name = "file_name", nullable = false)
	private String fileName;

	@Lob
	@Column(name = "file", nullable = false, columnDefinition = "LONGBLOB")
	private byte[] file;

	public Resume() {
		super();
	}

	public Resume(Long id, Long interviewId, String fileName, byte[] file) {
		super();
		this.id = id;
		this.interviewId = interviewId;
		this.fileName = fileName;
		this.file = file;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFile() {
		return file;
	}

	public Long getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Long interviewId) {
		this.interviewId = interviewId;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}