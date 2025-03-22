package com.restapplication.RestApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restapplication.RestApplication.bean.Employee;
import com.restapplication.RestApplication.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/")
	public List<Employee> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Integer employeeId) {
		return service.getEmployeeById(employeeId);
	}
	
	@PostMapping("/")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.insert(employee);
	}
	
	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.update(employee);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteEmployeeById(@PathVariable("id") Integer employeeId) {
		service.deleteEmployeeId(employeeId);
	}
	
	
	
	
	
	
	
	
	
	
	

}
