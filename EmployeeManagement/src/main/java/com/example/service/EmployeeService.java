package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Employee;

public interface EmployeeService {
	
	//This layer performs actions based on the methods like to add, delete, get employees
	public Employee addEmployee(Employee employee);
	
	public String removeEmployee(Integer id);
	
	public Optional <Employee> findEmpById(Integer id);
	
	public List<Employee> getAllEmployee();
	
	public Employee updateEmployee(Integer id, Employee employee);
}
