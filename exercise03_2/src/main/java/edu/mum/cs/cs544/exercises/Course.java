package edu.mum.cs.cs544.exercises;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private int id;
	private String coursenumber;
	private String name;
	@ManyToMany (mappedBy="courses")
	List<Student> students=new ArrayList<Student> ();
	
	
	
	
	public Course(String coursenumber, String name) {
		
		this.coursenumber = coursenumber;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public String getCoursenumber() {
		return coursenumber;
	}
	public void setCoursenumber(String coursenumber) {
		this.coursenumber = coursenumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	
	
	
	

}
