package com.springjpa.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springjpa.model.Staff;

public interface StaffRepository extends CrudRepository<Staff, Long>{
	List<Staff> findByName(String name);
}
