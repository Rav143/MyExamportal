package com.exam.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exception.ResultNotFoundException;
import com.exam.model.ResultDAO;
import com.exam.model.Result;

@RestController
public class ResultController {
	@Autowired
	ResultDAO resultDAO;
	
	@PostMapping("/addresult")
	public String addResult(@RequestBody Result result) {
		resultDAO.save(result);
		return "added result";
	}

	@GetMapping("/getallresults")
	public Iterable<Result> getAllResults() {
		return resultDAO.findAll();
	}
	
	@DeleteMapping("/deleteresult/{id}")
	public String deleteResult(@PathVariable("id") int id) {
		Optional<Result> opt=resultDAO.findById(id);
		if(!opt.isPresent()) {
			throw new ResultNotFoundException();
		}
		resultDAO.deleteById(id);
		return "result deleted";
	}
	
	@GetMapping("/findresult/{id}") 
	public Optional<Result> getResult(@PathVariable int id) {
		Optional<Result> opt=resultDAO.findById(id);
		if(!opt.isPresent()) {
			throw new ResultNotFoundException();
		}
		return resultDAO.findById(id);
	}
}