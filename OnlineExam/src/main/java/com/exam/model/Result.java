package com.exam.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Result {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date examDate;
	private String examScore;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private TestMgmt testmgmt;
	
	@OneToOne
	private Question question;
	
	public Result() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getExamScore() {
		return examScore;
	}

	public void setExamScore(String examScore) {
		this.examScore = examScore;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TestMgmt getTestmgmt() {
		return testmgmt;
	}

	public void setTestmgmt(TestMgmt testmgmt) {
		this.testmgmt = testmgmt;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
} 