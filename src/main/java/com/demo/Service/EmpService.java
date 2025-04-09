package com.demo.Service;

import java.util.List;
import java.util.Optional;

import com.demo.Entity.Employee;

public interface EmpService {
	
	List<Employee>getAllEmployees();
	Optional<Employee> getEmployeeByid(int id);
	Employee saveEmployee(Employee employee);
	Employee  updateEmployee(Employee employee);
	void deleteEmployeeById(int id);
}

