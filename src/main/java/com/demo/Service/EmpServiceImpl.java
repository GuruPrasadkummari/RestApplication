package com.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Entity.Employee;
import com.demo.Repository.EmployeeRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmployeeRepository employeeRepository;

	 
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	// Retrieve an employee by ID
	@Override
	public Optional<Employee> getEmployeeByid(int id) {
		return employeeRepository.findById(id);
	}

 
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	 
	@Override
	public Employee updateEmployee( Employee employee) {
		
		return employeeRepository.save(employee);
	}

	 
	@Override
	public void deleteEmployeeById(int id) {
		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
		} else {
			throw new RuntimeException("Employee not found with ID: " + id);
		}
	}
}
