package edu.mum.cs.cs544.exercises;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private int id;
	private String ISBN;
	private String title;
	private String author;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinTable(name="Book_Publisher",
				joinColumns={@JoinColumn(name="book_id")},
				inverseJoinColumns={@JoinColumn(name="publisher_id")}
			)
	private Publisher publisher;
	
	
	public Book() {
		
	}
	public Book(String iSBN, String title, String author, Publisher pub) {
		ISBN = iSBN;
		this.title = title;
		this.author = author;
		this.publisher=pub;
	}

	public int getId() {
		return id;
	}
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
