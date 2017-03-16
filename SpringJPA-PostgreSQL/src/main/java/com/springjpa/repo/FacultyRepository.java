package com.springjpa.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springjpa.model.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty, Long>{
	List<Faculty> findByName(String name);
}
