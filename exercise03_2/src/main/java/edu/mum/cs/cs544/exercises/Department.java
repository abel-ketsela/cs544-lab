package edu.mum.cs.cs544.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(mappedBy="department", cascade=CascadeType.PERSIST)
	List<Employee> employeeList=new ArrayList<Employee>();
	
	
	public Department(){
		
	}
	

	public Department(String name, Employee emp) {
		this.name = name;
		emp.setDepartment(this);
		this.employeeList.add(emp);
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmployeeList(Employee emp)
	{
		emp.setDepartment(this);
		employeeList.add(emp);
	}
	public List<Employee> getEmployeeList() {
		return Collections.unmodifiableList(employeeList);
	}

}
