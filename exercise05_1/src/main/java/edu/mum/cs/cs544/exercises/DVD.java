package edu.mum.cs.cs544.exercises;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DVD")
public class DVD extends Product {
	private String gener;

	
	public DVD(){
		
	}

	public DVD(String name, String description,String gener) {
		super(name,description);
		this.gener = gener;
	}
	public String getGener() {
		return gener;
	}

	public void setGener(String gener) {
		this.gener = gener;
	}
	
	

}
