package com.springjpa.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.model.Faculty;
//import com.springjpa.model.Staff;
import com.springjpa.repo.FacultyRepository;
//import com.springjpa.repo.StaffRepository;

@RestController
@RequestMapping(value = "/faculty")
public class FacultyController {
	@Autowired
	FacultyRepository facultyRepository;
	
	@RequestMapping("/save")
	public String process(){
		facultyRepository.save(new Faculty("JTK", Date.valueOf("2017-01-01")));
		facultyRepository.save(new Faculty("JTK", Date.valueOf("2017-01-02")));
		return "Done";
	}
	
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "<html>";
		
		for(Faculty f : facultyRepository.findAll()){
			result += "<div>" + f.toString() + "</div>";
		}
		
		return result + "</html>";
	}
	
	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = facultyRepository.findOne(id).toString();
		return result;
	}
	
	@RequestMapping("/findbyname")
	public String fetchDataByName(@RequestParam("name") String name){
		String result = "<html>";
		
		for(Faculty f : facultyRepository.findByName(name)){
			result += "<div>" + f.toString() + "</div>"; 
		}
		
		return result + "</html>";
	}
}

