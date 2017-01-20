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
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	private String firstname;
	private String lastname;
	@OneToMany(mappedBy="customer", cascade=CascadeType.PERSIST)
	private List<Order> orders=new ArrayList<Order>();
	
	
	
	
	public Customer(){
		
	}
	
	
	public List<Order> getOrders() {
		return Collections.unmodifiableList(orders);
	}


	public void addOrders(Order order) {
		order.setCustomer(this);
		this.orders.add(order);
	}


	public Customer(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}


	public int getId() {
		return id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	
}
