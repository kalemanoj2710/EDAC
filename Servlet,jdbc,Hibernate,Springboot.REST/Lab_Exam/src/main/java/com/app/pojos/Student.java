package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 35)
	@NotBlank
	@Size(max = 35, message = "Name should be less than 35 characters")
	private String name;
	
	@Column(length = 255)
	@NotBlank
	@Size(max = 255, message = "Address should be less than 255 characters")
	private String address;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@Min(value=8, message = "CGPA should be greater than 7")
	private double cgpa;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private Course course;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(Integer id,
			@NotBlank @Max(value = 35, message = "Name should be less than 35 characters") String name,
			@NotBlank @Max(value = 255, message = "Address should be less than 255 characters") String address,
			LocalDate dob, @Min(value = 8, message = "CGPA should be greater than 7") double cgpa, Course course) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.cgpa = cgpa;
		this.course = course;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", dob=" + dob + ", cgpa=" + cgpa
				+ ", course=" + course + "]";
	}
	
	
	
}
