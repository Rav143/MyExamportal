package com.exam.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tests")
public class TestMgmt {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String courseType;
	
	public TestMgmt() {
		
	}

	public TestMgmt(String courseType) {
		this.courseType = courseType;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	
	
}