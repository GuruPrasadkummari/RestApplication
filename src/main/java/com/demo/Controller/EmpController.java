package com.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.Employee;
import com.demo.Service.EmpServiceImpl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/employee")
public class EmpController {
	@Autowired
	private EmpServiceImpl empservice;
	@GetMapping("/")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Employee> getAllEmployees() {
		return empservice.getAllEmployees();
	}
	@GetMapping("/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public Employee getEmployeeById(@PathVariable int id) {
		Optional<Employee> employee= empservice.getEmployeeByid(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new RuntimeException("Employee not found with Id:" + id);
		}
	}
	
	@PutMapping("/")
    @ResponseStatus(HttpStatus.OK)     
    public Employee updateEmployee(@RequestBody Employee employee) {

        if (employee.getEmpId() == 0) {
            throw new RuntimeException("Employee ID is missing. Cannot update.");
        }

        return empservice.updateEmployee(employee);
    }
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		return empservice.saveEmployee(employee);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployeeById(@PathVariable int id) {
		empservice.deleteEmployeeById(id);
		
	}
		

}
