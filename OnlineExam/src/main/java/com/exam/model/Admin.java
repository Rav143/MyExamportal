
package com.exam.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String adminName;
	private String adminaddress;
	private String aemail;
	private String apassword;
	
	@OneToMany
	private List<User> userlist;
	
	public Admin() {
		
	}
	
	
	public List<User> getUserlist() {
		return userlist;
	}



	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminaddress() {
		return adminaddress;
	}

	public void setAdminaddress(String adminaddress) {
		this.adminaddress = adminaddress;
	}

	public String getAemail() {
		return aemail;
	}

	public void setAemail(String aemail) {
		this.aemail = aemail;
	}

	public String getApassword() {
		return apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	
	

}