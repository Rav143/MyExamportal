package com.exam.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMgmtDAO extends CrudRepository<TestMgmt,Integer>{

}