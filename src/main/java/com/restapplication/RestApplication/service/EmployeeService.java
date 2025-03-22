package com.restapplication.RestApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapplication.RestApplication.bean.Employee;
import com.restapplication.RestApplication.dao.EmployeeDAO;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDAO dao;
	
	public List<Employee> getAll(){
		return dao.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		return dao.findById(id);
	}
	
	public Employee insert(Employee employee) {
		return dao.save(employee);
	}
	
	public Employee update(Employee employee) {
		return dao.update(employee);
	}
	
	public void deleteEmployeeId(int id) {
		dao.deleteById(id);
	}
	
}
