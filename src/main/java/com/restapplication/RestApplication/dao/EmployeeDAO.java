package com.restapplication.RestApplication.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restapplication.RestApplication.bean.Employee;

@Component
public class EmployeeDAO {
	
	public static final List<Employee> LIST = new ArrayList<>();
	
	public EmployeeDAO() {
	}
	
	static {
		LIST.add(new Employee(1, "Tom", "IT", 10000));
		LIST.add(new Employee(2, "Scott", "ADMIN", 20000));
		LIST.add(new Employee(3, "Bill", "IT", 30000));
		LIST.add(new Employee(4, "Michelle", "HR", 10000));
	}
	
	public List<Employee> findAll(){
		return LIST;
	}
	
	public Employee findById(int id) {
		return LIST.stream().filter(employee -> employee.getId() == id).findFirst().get();
	}
	
	public Employee save(Employee employee) {
		LIST.add(employee);
		return employee;
	}
	
	public Employee update(Employee employee) {
		deleteById(employee.getId());
		LIST.add(employee);
		return employee;
	}
	
	public void deleteById(int id) {
		Employee employee = findById(id);
		LIST.remove(employee);
	}
	
}
