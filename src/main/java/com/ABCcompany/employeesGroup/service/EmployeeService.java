package com.ABCcompany.employeesGroup.service;

import java.util.List;

import com.ABCcompany.employeesGroup.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	List<Employee> getFilteredEmployees();
	
}
