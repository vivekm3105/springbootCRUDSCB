package com.example.springbootCrud.springbootCrudSCB.controller;

import java.util.List;

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

import com.example.springbootCrud.springbootCrudSCB.exception.ResourceNotFoundException;
import com.example.springbootCrud.springbootCrudSCB.model.Employee;
import com.example.springbootCrud.springbootCrudSCB.repository.EmployeeRepository;
import com.example.springbootCrud.springbootCrudSCB.servic.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired	
	private EmployeeService employeeService;
	
		
	// Posting new Employee Data
	@PostMapping("/createEmployees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
		
	}
	
	//fetch All employees
	@GetMapping
	public List<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();
		
		
	}
	
	//get employee by ID
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable("id") long id) throws ResourceNotFoundException {
		
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
		
	}
	
	//update Employee
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) throws ResourceNotFoundException{
		
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),  HttpStatus.OK);
		
		//delete employee
		
		
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) throws ResourceNotFoundException{
		
		employeeService.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee Deleted Successfully", HttpStatus.OK);
		
		
	}

	}
	
