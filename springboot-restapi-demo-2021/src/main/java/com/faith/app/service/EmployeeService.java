package com.faith.app.service;

import java.util.List;

import com.faith.app.entity.Employee;

public interface EmployeeService {

		//get all employees
		public List<Employee> findAll();
		
		//get a particular employee
		public Employee findById(int theId);
		
		// insert/update employee
		public void save(Employee theEmployee);
		
		//delete employee
		public void deleteById(int theId);
}
