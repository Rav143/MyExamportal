package com.exam.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exception.QuestionNotFoundException;
import com.exam.model.Question;
import com.exam.model.QuestionDAO;

@RestController
public class QuestionController {

	@Autowired
	QuestionDAO questionDAO;
	
	@PostMapping("/addquestion")
	public String addQuestion(@RequestBody Question question) {
		questionDAO.save(question);
		return "question added";
	}
	
	@GetMapping("/getallquestions")
	public Iterable<Question> getAllQuestions() {
		return questionDAO.findAll();
	}
	@DeleteMapping("/deletequestion/{id}")
	public String deleteQuestion(@PathVariable("id") int id) {
		Optional<Question> opt=questionDAO.findById(id);
		if(!opt.isPresent()) {
			throw new QuestionNotFoundException();
		}
		questionDAO.deleteById(id);
		return "question deleted";
	}
	@GetMapping("/findquestion/{id}") 
	public Optional<Question> getQuestion(@PathVariable int id) {
		Optional<Question> opt=questionDAO.findById(id);
		if(!opt.isPresent()) {
			throw new QuestionNotFoundException();
		}
		return questionDAO.findById(id);
	}
}