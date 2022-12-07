
 package com.example.springbootCrud.springbootCrudSCB.servic;
 
 import java.util.List;

import com.example.springbootCrud.springbootCrudSCB.exception.ResourceNotFoundException;
import com.example.springbootCrud.springbootCrudSCB.model.Employee;
 
 public interface EmployeeService {
 
 Employee saveEmployee(Employee employee);
 
 List<Employee> getAllEmployees();
 
 Employee getEmployeeById(long id) throws ResourceNotFoundException;
 
 Employee updateEmployee(Employee employee, long id) throws ResourceNotFoundException;
	
 void deleteEmployee(long id) throws ResourceNotFoundException;
 }
 