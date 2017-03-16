package com.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.model.Staff;
import com.springjpa.repo.FacultyRepository;
import com.springjpa.repo.StaffRepository;

@RestController
@RequestMapping(value = "/staff")
public class StaffController {
	
	@Autowired
	StaffRepository staffRepository;

	@Autowired
	FacultyRepository facultyRepository;
	
	@RequestMapping("/save")
	public String process(){
		staffRepository.save(new Staff("name_1", "street_1", "position_1", facultyRepository.findOne((long) 11)));
		staffRepository.save(new Staff("name_2", "street_2", "position_2", facultyRepository.findOne((long) 12)));
		return "Done";
	}
	
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "<html>";
		
		for(Staff cust : staffRepository.findAll()){
			result += "<div>" + cust.toString() + "</div>";
		}
		
		return result + "</html>";
	}
	
	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = staffRepository.findOne(id).toString();
		return result;
	}
	
	@RequestMapping("/findbyname")
	public String fetchDataByName(@RequestParam("name") String name){
		String result = "<html>";
		
		for(Staff s: staffRepository.findByName(name)){
			result += "<div>" + s.toString() + "</div>"; 
		}
		
		return result + "</html>";
	}		
}

