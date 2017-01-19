package edu.mum.cs.cs544.exercises;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;


@Entity
public class School {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(cascade=CascadeType.PERSIST)
	@MapKey(name="studentid")
	private Map<String, Student> students=new HashMap<String,Student>();
	
	
	public School(){
		
	}
	


	public School(String name) {
		this.name = name;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Map<String, Student> getStudents() {
		return Collections.unmodifiableMap(this.students);
	}


	public void addStudents(Student student) {
		this.students.put(student.getStudentid(), student);
	}
	
	
	

}
