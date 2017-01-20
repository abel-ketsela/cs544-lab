package edu.mum.cs.cs544.exercises;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Appointment {
	@Id
	@GeneratedValue
	 private int id;
	 private String appdate;
	 @OneToOne(cascade=CascadeType.PERSIST)
	 private Patient patient;
	 @Embedded
	 private Payment payment;
	 @OneToOne(cascade=CascadeType.PERSIST)
	 private Doctor doctor;
	 
	 
	 public Appointment()
	 {
		 
	 }
	
	public Appointment(String appdate, Patient patient, Payment payment, Doctor doctor) {
		super();
		this.appdate = appdate;
		this.patient = patient;
		this.payment = payment;
		this.doctor = doctor;
	}

	public int getId() {
		return id;
	}
	
	public String getAppdate() {
		return appdate;
	}
	public void setAppdate(String appdate) {
		this.appdate = appdate;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	} 
	 
	 
}