package edu.mum.cs.cs544.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Passenger {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="passenger")
	@OrderColumn(name="flight_sequence")
	private List<Flight> flights=new ArrayList<Flight>();
	
	
	public Passenger(){
		
	}
	
	
	
	public Passenger(String name) {
		
		this.name = name;
	}



	public List<Flight> getFlights() {
		return Collections.unmodifiableList(flights);
	}

	public void addFlights(Flight flight) {
		flight.setPassenger(this);
		this.flights.add(flight);
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
