package com.ABCcompany.employeesGroup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ABCcompany.employeesGroup.model.Employee;
import com.ABCcompany.employeesGroup.repository.EmployeeRepository;
import com.ABCcompany.employeesGroup.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository  employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}


	@Override
	public  List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}
	
	public List<Employee> getFilteredEmployees(
	        @RequestParam(value = "married", required = false) Boolean married,
	        @RequestParam(value = "salary", required = false) Integer salary)
	    {
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeRepository);
	List<Employee> employees =employeeService.getAllEmployees();
	        List<Employee> filteredEmployees = new ArrayList<>();

	        for (Employee e : employees) {
	            if (married != null && e.isMarried() != married) {
	                continue;	
	            }
	            if (salary != null && e.getSalary() >= salary) {
	                continue;
	            }
	            filteredEmployees.add(e);
	        }

	        return filteredEmployees;
	    }


	@Override
	public List<Employee> getFilteredEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}

