package com.mybootproject.playground.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybootproject.playground.model.Employee;
import com.mybootproject.playground.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/employee")
	public void postEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/employee")
	public List<Employee> getEmployee(@RequestParam Integer page, @RequestParam Integer size) {
		Pageable pageable=PageRequest.of(page, size);
		return employeeRepository.findAll(pageable).getContent();	
		}
}
