package com.example.springbootCrud.springbootCrudSCB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootCrud.springbootCrudSCB.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
