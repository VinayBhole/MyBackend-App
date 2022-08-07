package com.mybootproject.playground.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybootproject.playground.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
