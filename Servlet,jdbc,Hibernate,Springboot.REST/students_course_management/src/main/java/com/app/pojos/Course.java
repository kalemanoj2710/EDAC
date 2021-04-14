package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses_tbl")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseid;
	
	@Column(length = 20)
	private String subject;

	//owning side : one course may have many students
	@OneToMany(mappedBy = "optedCourse",cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList<>();

	public Course() {
		
	}

	public Course(Integer course_id, String subject) {
		super();
		this.courseid = course_id;
		this.subject = subject;
	}

	public Integer getCourseid() {
		return courseid;
	}

	public void setCourseid(Integer course_id) {
		this.courseid = course_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + courseid + ", subject=" + subject + "]";
	}
	
	public void addStudent(Student s) {
		students.add(s);
		s.setOptedCourse(this);
	}
}
