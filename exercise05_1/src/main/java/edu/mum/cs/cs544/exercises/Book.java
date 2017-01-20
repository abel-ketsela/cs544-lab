package edu.mum.cs.cs544.exercises;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BOOK")
public class Book extends Product {
	private String title;

	
	public Book(){
		
	}

	public Book(String name, String description,String title) {
		super(name,description);
		this.title = title;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	


}
