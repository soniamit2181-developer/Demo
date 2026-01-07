package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roll_no;
	
	@Column(name="studemt_name", nullable = false)
	private String studentName;
	
	@Column(name="hobbies")
	private String hobbies;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;
	
	@ManyToMany()
	@JoinTable(
		name = "student_course",
		joinColumns = @JoinColumn(name="student_id", referencedColumnName = "roll_no"),
		inverseJoinColumns = @JoinColumn(name="course_id", referencedColumnName = "id")
	)
	private Set<Course> courses;

	public long getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(long roll_no) {
		this.roll_no = roll_no;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
}
