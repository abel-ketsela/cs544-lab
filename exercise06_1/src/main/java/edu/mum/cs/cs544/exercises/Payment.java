package edu.mum.cs.cs544.exercises;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Payment {
	
	private String paydate;
	private double amount;
	
	
	
	public Payment(){
		
	}
	public Payment(String paydate, double amount) {
		super();
		this.paydate = paydate;
		this.amount = amount;
	}
	public String getPaydate() {
		return paydate;
	}
	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	} 
	
	
	 
}