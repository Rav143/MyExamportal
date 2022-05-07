package com.exam.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO extends CrudRepository<Admin,Integer>{

	public Optional<Admin> findByAdminName(String adminName);

}