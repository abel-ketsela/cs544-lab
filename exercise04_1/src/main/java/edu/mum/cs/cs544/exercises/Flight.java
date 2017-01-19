package edu.mum.cs.cs544.exercises;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue
	private int id;
	private String flightnumber;
	@Column(name="from_place")
	private String from;
	@Column(name="to_place")
	private String to;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne
	private Passenger passenger; 
	
	
	
	
	public int getId() {
		return id;
	}
	
	public String getFlightnumber() {
		return flightnumber;
	}
	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	

}
