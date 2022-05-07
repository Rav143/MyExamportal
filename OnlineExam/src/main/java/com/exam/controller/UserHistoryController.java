package com.exam.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exception.UserHistoryNotFoundException;
import com.exam.model.UserHistory;
import com.exam.model.UserHistoryDAO;

@RestController
public class UserHistoryController {
	@Autowired
	UserHistoryDAO userhistoryDAO;
	
	@PostMapping("/adduserhistory")
	public String addUserHistory(@RequestBody UserHistory userhistory) {
		userhistoryDAO.save(userhistory);
		return "added userhistory";
	}

	@GetMapping("/getalluserhistorys")
	public Iterable<UserHistory> getAllUserHistorys() {
		return userhistoryDAO.findAll();
	}
	
	@DeleteMapping("/deleteuserhistory/{id}")
	public String deleteUserHistory(@PathVariable("id") int id) {
		Optional<UserHistory> opt=userhistoryDAO.findById(id);
		if(!opt.isPresent()) {
			throw new UserHistoryNotFoundException();
		}
		userhistoryDAO.deleteById(id);
		return "userhistory deleted";
	}

}