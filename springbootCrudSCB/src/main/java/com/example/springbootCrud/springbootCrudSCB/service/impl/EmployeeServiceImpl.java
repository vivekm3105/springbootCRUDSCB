
  package com.example.springbootCrud.springbootCrudSCB.service.impl;
 
 import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; import
 org.springframework.stereotype.Service;

import com.example.springbootCrud.springbootCrudSCB.exception.ResourceNotFoundException;
import com.example.springbootCrud.springbootCrudSCB.model.Employee; import
  com.example.springbootCrud.springbootCrudSCB.repository.EmployeeRepository;
 import com.example.springbootCrud.springbootCrudSCB.servic.EmployeeService;
 
  @Service 
  public class EmployeeServiceImpl implements EmployeeService {
 
  @Autowired 
 private EmployeeRepository employeeRepository;
 
 
  @Override 
  public Employee saveEmployee(Employee employee) { 
	  Employee emp = employeeRepository.save(employee); 
	  return emp; 
	  }


@Override
public List<Employee> getAllEmployees() {

	List<Employee> employees = employeeRepository.findAll();
	return employees;
}


@Override
public Employee getEmployeeById(long id) throws ResourceNotFoundException {

	Optional<Employee> employee = employeeRepository.findById(id);
	if(employee.isPresent()) {
		return employee.get();
	}
	
	else {
		throw new ResourceNotFoundException("Employee", "Id", id);
	}
	
}


@Override
public Employee updateEmployee(Employee employee, long id) throws ResourceNotFoundException {
// we need to check whether the emp with given id exists or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	
		//set the values that we get from the user to existing employee object
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		
		// save existing employee to DB
		employeeRepository.save(existingEmployee);

	return existingEmployee;
}


@Override
public void deleteEmployee(long id) throws ResourceNotFoundException {

	//check whether a employee exist in db or not
	employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	
	employeeRepository.deleteById(id);
}
 
 }
 