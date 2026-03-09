package com.example.serviceIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepo;
import com.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public Employee addEmployee(Employee employee) {
		
		Employee emp =  employeeRepo.save(employee);
		return emp;
	}

	@Override
    public String removeEmployee(Integer id) {
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
            return "Deleted employee with ID " + id;
        }
        return "Employee not found";
    }

	@Override
    public Optional<Employee> findEmpById(Integer id) { 
        return employeeRepo.findById(id);
    }

	@Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

	@Override
	public Employee updateEmployee(Integer id, Employee employee) {
	    // 1. Find the existing employee in the database
	    return employeeRepo.findById(id).map(existing -> {
	        
	        // 2. Update the fields only if they are provided in the request body
	        if (employee.getName() != null) existing.setName(employee.getName());
	        if (employee.getAge() != null) existing.setAge(employee.getAge());
	        if (employee.getState() != null) existing.setState(employee.getState());
	        if (employee.getType() != null) existing.setType(employee.getType());
	        if (employee.getSalary() != null) existing.setSalary(employee.getSalary());

	        return employeeRepo.save(existing); 
	        
	    }).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
	}
}

