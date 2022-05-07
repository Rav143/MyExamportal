package com.exam.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exception.AdminExistsException;
import com.exam.exception.AdminNotFoundException;
import com.exam.model.Admin;
import com.exam.model.AdminDAO;

@RestController
public class AdminController {
	@Autowired
	AdminDAO adminDAO;
	
	@PostMapping("/addadmin")
	public String addAdmin(@RequestBody Admin admin) {
		Optional<Admin> opt=adminDAO.findByAdminName(admin.getAdminName());
		if(opt.isPresent()) {
			throw new AdminExistsException();
		}
		adminDAO.save(admin);
		return "admin added";
	}

	@GetMapping("/getalladmins")
	public Iterable<Admin> getAllAdmin() {
		return adminDAO.findAll();
	}
	
	@DeleteMapping("/deleteadmin/{id}")
	public String deleteAdmin(@PathVariable("id") int id) {
		Optional<Admin> opt=adminDAO.findById(id);
		if(!opt.isPresent()) {
			throw new AdminNotFoundException();
		}
		adminDAO.deleteById(id);
		return "admin deleted";
	}
	@GetMapping("/findadmin/{id}") 
	public Optional<Admin> getAdmin(@PathVariable int id) {
		Optional<Admin> opt=adminDAO.findById(id);
		if(!opt.isPresent()) {
			throw new AdminNotFoundException();
		}
		return adminDAO.findById(id);
	}
}