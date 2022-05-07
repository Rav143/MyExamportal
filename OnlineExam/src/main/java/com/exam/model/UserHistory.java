package com.exam.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="userhistory")
public class UserHistory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int testScore;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date testDate;
	
	@OneToOne
	private TestMgmt testMgmt;
	
	@OneToOne
	private User user;
	
	public UserHistory() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTestScore() {
		return testScore;
	}

	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public TestMgmt getTestMgmt() {
		return testMgmt;
	}

	public void setTestMgmt(TestMgmt testMgmt) {
		this.testMgmt = testMgmt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}