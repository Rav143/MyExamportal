package com.exam.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exception.TestNotFoundException;
import com.exam.model.TestMgmtDAO;
import com.exam.model.TestMgmt;

@RestController
public class TestMgmtController {
	@Autowired
	TestMgmtDAO testmgmtDAO;
	
	@PostMapping("/addtest")
	public String registerTestMgmt(@RequestBody TestMgmt testmgmt) {
		testmgmtDAO.save(testmgmt);
		return "registered testmgmt";
	}
	
	@GetMapping("/getalltests")
	public Iterable<TestMgmt> getAllTestMgmts() {
		return testmgmtDAO.findAll();
	}
	
	@DeleteMapping("/deletetest/{id}")
	public String deleteTestMgmt(@PathVariable("id") int id) {
		Optional<TestMgmt> opt=testmgmtDAO.findById(id);
		if(!opt.isPresent()) {
			throw new TestNotFoundException();
		}
		testmgmtDAO.deleteById(id);
		return "testmgmt deleted";
	}
	@GetMapping("/findtest/{id}") 
	public Optional<TestMgmt> getTestMgmt(@PathVariable int id) {
		Optional<TestMgmt> opt=testmgmtDAO.findById(id);
		if(!opt.isPresent()) {
			throw new TestNotFoundException();
		}
		return testmgmtDAO.findById(id);
	}
}