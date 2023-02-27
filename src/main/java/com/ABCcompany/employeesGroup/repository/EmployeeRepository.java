package com.ABCcompany.employeesGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ABCcompany.employeesGroup.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
