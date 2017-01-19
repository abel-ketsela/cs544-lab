package edu.mum.cs.cs544.exercises;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Publisher {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	public Publisher()
	{
		
	}
	
	
	public Publisher(String name) {
		this.name = name;
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
	
	
	
	

}
