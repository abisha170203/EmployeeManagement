package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public String removeEmployee(Integer id);
	
	public Optional <Employee> findEmpById(Integer id);
	
	public List<Employee> getAllEmployee();
	
	public Employee updateEmployee(Integer id, Employee employee);
}

