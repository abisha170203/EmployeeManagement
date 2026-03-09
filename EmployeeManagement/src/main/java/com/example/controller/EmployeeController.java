package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.serviceIMPL.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl empservice;

    @GetMapping("/home")
    public String homePage() {
        return "Welcome to Management System";
    }

    @PostMapping("/addEmp")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee emp = empservice.addEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @DeleteMapping("/removeEmp/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable Integer id) { 
        empservice.removeEmployee(id);
        return new ResponseEntity<>("Removed Successfully", HttpStatus.OK);
    }

    @GetMapping("/findEmp/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Integer id) {
        return empservice.findEmpById(id)
                .map(employee -> new ResponseEntity<>(employee, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/listEmp")
    public ResponseEntity<List<Employee>> listOfEmployees() {
        List<Employee> lEmp = empservice.getAllEmployee();
        return new ResponseEntity<>(lEmp, HttpStatus.OK);
    }

    @PutMapping("/updateEmp/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        Employee updatedEmployee = empservice.updateEmployee(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
}


