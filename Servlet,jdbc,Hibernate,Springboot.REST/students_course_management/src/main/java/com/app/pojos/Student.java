package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "student_tbl")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentid;
	@Column(length = 30 , nullable = false)
	private String name;
	@Column(length = 100 , nullable = false)
	private String address;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@Column
	private double cgpa;
	
	@ManyToOne
	@JoinColumn(name = "courseid")
	private Course optedCourse;
	
	public Student() {
		
	}

	public Student(Integer student_id, String name, String address, LocalDate dob, double cgpa) {
		super();
		this.studentid = student_id;
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.cgpa = cgpa;
	}

	public Integer getStudentId() {
		return studentid;
	}

	public void setStudentId(Integer student_id) {
		this.studentid = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + studentid + ", name=" + name + ", address=" + address + ", dob=" + dob
				+ ", cgpa=" + cgpa + "]";
	}

	public Course getOptedCourse() {
		return optedCourse;
	}

	public void setOptedCourse(Course optedCourse) {
		this.optedCourse = optedCourse;
	}
	
	
	
}
