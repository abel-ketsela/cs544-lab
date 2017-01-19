package edu.mum.cs.cs544.exercises;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String employeenumber;
	private String name;
	@ManyToOne
	private Department department;
	
	
	public int getId() {
		return id;
	}
	
	public Employee() {
		
		
	}
	
	public Employee(String employeenumber, String name) {
		
		this.employeenumber = employeenumber;
		this.name = name;
	}

	public String getEmployeenumber() {
		return employeenumber;
	}
	public void setEmployeenumber(String employeenumber) {
		this.employeenumber = employeenumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
	
}
