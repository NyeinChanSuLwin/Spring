package com.ncsl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ncsl.demo.entity.*;
import com.ncsl.demo.entity.repository.*;
@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/add_student/name={name}/address={address}")
	public Student addstudent(@PathVariable("name") String name,@PathVariable("address") String address) {
		Student s = new Student();
		s.setName(name);
		s.setAddress(address);
		studentRepository.saveAndFlush(s);
		Student s2 = studentRepository.findByName(s.getName());
		return s2;
	}
	
	@GetMapping("/students")
	public List<Student> allstudents(){
		List<Student> s = studentRepository.findAll();
		return s;
	}
}
