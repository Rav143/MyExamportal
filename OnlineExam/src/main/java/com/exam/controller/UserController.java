package com.exam.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exception.EmailIdExistsException;
import com.exam.exception.PasswordNotSameException;
import com.exam.exception.UserExistsException;
import com.exam.exception.UserNotFoundException;
import com.exam.model.User;
import com.exam.model.UserDAO;

@RestController
public class UserController {
	@Autowired
	UserDAO userDAO;
	
	@PostMapping("/registeruser")
	public String registerUser(@RequestBody User user) {
		Optional<User> opt=userDAO.findByUserName(user.getUserName());
		Optional<User> opt2=userDAO.findByemail(user.getEmail());
		if(opt.isPresent()) {
			throw new UserExistsException();
		}
		if(opt2.isPresent()) {
			throw new EmailIdExistsException();
		}
		String p=user.getPassword();
		String p2=user.getConfirmPassword();
		if(!p.equals(p2)) {
			throw new PasswordNotSameException();
		}
		userDAO.save(user);
		return "registered user";
	}
	@PatchMapping("/updateuser/{id}")
	public String updateUser(@PathVariable("id") int id,@RequestBody User user) {
		userDAO.save(user);
		return "user details updated";
	}
	@GetMapping("/getallusers")
	public Iterable<User> getAllUsers() {
		return userDAO.findAll();
	}
	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		Optional<User> opt=userDAO.findById(id);
		if(!opt.isPresent()) {
			throw new UserNotFoundException();
		}
		userDAO.deleteById(id);
		return "user deleted";
	}
	@GetMapping("/finduser/{id}") 
	public Optional<User> getUser(@PathVariable int id) {
		Optional<User> opt=userDAO.findById(id);
		if(!opt.isPresent()) {
			throw new UserNotFoundException();
		}
		return userDAO.findById(id);
	}
}