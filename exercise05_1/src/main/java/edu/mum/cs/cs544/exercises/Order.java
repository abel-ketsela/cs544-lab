package edu.mum.cs.cs544.exercises;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="`Order`")
public class Order {
	@Id
	@GeneratedValue
	private int id;
	private String orderid;
	private Date date;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Customer customer;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="order_id")
	private List<OrderLine> orderline=new ArrayList<OrderLine>();
	
	
	public List<OrderLine> getOrderline() {
		return orderline;
	}

	public void addOrderline(OrderLine orderline) {
		this.orderline.add(orderline);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order(){
		
	}
	
	public Order(String orderid, Date date) {
		this.orderid = orderid;
		this.date = date;
	}

	public int getId() {
		return id;
	}
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date dtae) {
		this.date = dtae;
	}
	
	
	
	

}
