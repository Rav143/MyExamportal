package com.exam.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDAO extends CrudRepository<Question, Integer>{

}