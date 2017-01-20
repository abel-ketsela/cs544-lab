package edu.mum.cs.cs544.exercises;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type",discriminatorType=DiscriminatorType.STRING)
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	
	
	public Product(){
		
	}
	
	public Product(String name, String description) {
		
		this.name = name;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
		
}
