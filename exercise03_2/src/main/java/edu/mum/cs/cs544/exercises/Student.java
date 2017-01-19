package edu.mum.cs.cs544.exercises;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id;
	private String studentid;
	private String firstname;
	private String lastname;
	@ManyToMany (cascade=CascadeType.PERSIST)
	@JoinTable(name="student_course",
	joinColumns={@JoinColumn(name="student_id")},
	inverseJoinColumns={@JoinColumn(name="course_id")}
)
	private List<Course> courses=new ArrayList<Course>();
	
	public Student() {
		
	}
	
	public Student(String studentid, String firstname, String lastname, Course course) {
		course.addStudent(this);
		this.addCourse(course);
		this.studentid = studentid;
		this.firstname = firstname;
	}

	public int getId() {
		return id;
	}
	
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void addCourse(Course course) {
		this.courses.add(course);
	}
	
	
	

}
