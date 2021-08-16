package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.Employee;
import com.faith.app.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	//service
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	//1
	// expose "/employees" and return list of employees
	// /api/employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	
	//2
	// add mapping for GET /employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee=employeeService.findById(employeeId);
		
		if(theEmployee==null) {
			throw new RuntimeException("Employee id is not found - " + employeeId);
		}
		
		return theEmployee;
	}
	
	
	//3
	// add mapping for POST /employees - add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		// also just in case users pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	//4
	// add mapping for PUT /employees - update existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	
	//5
	// add mapping for DELETE /employees/{employeeId} - delete employee
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee=employeeService.findById(employeeId);
		
		// throw exception if null
		if(theEmployee==null) {
			throw new RuntimeException("Employee id is not found - " + employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id : " + employeeId ;
	}
	
}
