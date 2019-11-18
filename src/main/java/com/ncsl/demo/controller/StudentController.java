package com.ncsl.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ncsl.demo.entity.*;
import com.ncsl.demo.entity.repository.*;
@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/")
    String home() {
      return helloworld();
    }
    String helloworld() {
    	return "hello World";
    }
    
	@GetMapping("/students")
	public List<Student> allstudents(){
		List<Student> s = studentRepository.findAll();
		return s;
	}
	
	@GetMapping("/add_student/name={name}/address={address}")
	public List<Student> addstudent(@PathVariable("name") String name,@PathVariable("address") String address) {
		Student s = new Student();
		s.setName(name);
		s.setAddress(address);
		studentRepository.saveAndFlush(s);
		Student s2 = studentRepository.findByName(s.getName());
		return allstudents();
	}
	@RequestMapping("add_student")
	public List<Student> addstudentpost(HttpServletRequest req){
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		Student s = new Student();
		s.setName(name);
		s.setAddress(address);
		studentRepository.saveAndFlush(s);
		List<Student> stu = studentRepository.findAll();
		return stu;
	}
	
}
