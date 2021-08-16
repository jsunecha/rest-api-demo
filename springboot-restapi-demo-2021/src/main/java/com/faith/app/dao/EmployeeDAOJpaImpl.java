package com.faith.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements ProfessorDAO {

	//import
	private EntityManager entityManager;
	
	//dependency Injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	
	//Listing all employees
	@Override
	public List<Employee> findAll() {
		
		// create a query by using JPQL
		Query theQuery =entityManager.createQuery("from Employee");
		
		// execute query and get result list
		List<Employee> employees =theQuery.getResultList();
		
		// return the result
		return employees;
	}


	//find by id for particular employee
	@Override
	public Employee findById(int theId) {
		
		// get employee
		Employee theEmployee =entityManager.find(Employee.class, theId);
		
		// return employee
		return theEmployee;
	}

	//Save employee both Insert and Update
	@Override
	public void save(Employee theEmployee) {
	
		//Insert or Update the employee
		Employee dbEmployee =entityManager.merge(theEmployee);
		
		// update with id from db.. ... 
		// so we can get generated id for save/insert
		theEmployee.setId(dbEmployee.getId());
		
	}

	//Delete employee
	@Override
	public void deleteById(int theId) {
		
		// delete object with primary key
		Query theQuery =entityManager.createQuery("delete from Employee where id=:employeeId");
		
		//set parameter value
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	
	}

}
