package edu.mum.cs.cs544.exercises;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class OrderLine {
	@Id
	@GeneratedValue
	private int id;
	private double quantity;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Product product;
	
	

	public OrderLine(double quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderLine() {
		
	}
	
	public OrderLine(double quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}
	
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	

}
