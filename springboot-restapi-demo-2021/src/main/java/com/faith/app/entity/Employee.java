package com.faith.app.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblemployee")
public class Employee {
	
	//data members / properties/fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employeeid")
	private Integer id;
	
	@Column(name = "employeename",nullable = false,length=60)
	private String employeeName;
	
	@Column(name = "designation",nullable = false,length=60)
	private String designation;
	
	@Column(name = "dateofjoining")
	private Date dateofjoining;
	
	//foreign Key
	//Many employees - one department
	
	@ManyToOne
	@JoinColumn(name = "departmentid")
	private Department department;
	
		
	// default constructor
	public Employee() {
		super();
	}

	// parameterized constructor
	public Employee(Integer id, String employeeName, String designation, Date dateofjoining, Department department) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.designation = designation;
		this.dateofjoining = dateofjoining;
		this.department = department;
	}
	
	
	public Employee(Integer id, String employeeName, String designation) {
		this.id = id;
		this.employeeName = employeeName;
		this.designation = designation;
	}

	//setters and getters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDateofjoining() {
		return dateofjoining;
	}

	public void setDateofjoining(Date dateofjoining) {
		this.dateofjoining = dateofjoining;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	//Override toString
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", designation=" + designation
				+ ", dateofjoining=" + dateofjoining + ", department=" + department + "]";
	}
	
	
	
	

}
