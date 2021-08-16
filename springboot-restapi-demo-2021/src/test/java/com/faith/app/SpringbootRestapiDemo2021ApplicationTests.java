package com.faith.app;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.faith.app.dao.ProfessorDAO;
import com.faith.app.entity.Employee;
import com.faith.app.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootRestapiDemo2021ApplicationTests {

	/*
	@Test
	void contextLoads() {
	}*/
	
	@Autowired
	private EmployeeService employeeService;
	
	//MockDatabase
	@MockBean
	private ProfessorDAO employeeDAO;
	
	
	// findAllTest		-- Howmany records it returns
	@Test
	public void findAllTest() {
		when(employeeDAO.findAll()).thenReturn(Stream
				.of(new Employee(101,"Sanjay","Manager"),
						new Employee(102,"Ganga","Tester"))
				.collect(Collectors.toList()));
		
		assertEquals(2,employeeService.findAll().size());
	}
	
	// SaveTest			-- howmany times it is  hitting 
	@Test
	public void saveTest() {
		Employee employee = new Employee(101,"Mary","Analyst");
		employeeService.save(employee);
		
		verify(employeeDAO,times(1)).save(employee);
		
	}
	
	

}
