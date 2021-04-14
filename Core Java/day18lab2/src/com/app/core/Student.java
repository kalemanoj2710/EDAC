package com.app.core;

import java.time.LocalDate;

public class Student {
	private String student_id;
	private Course course;
	private String name;
	private int marks;
	private LocalDate birthDate;

	public Student(String student_id, Course course, String name, int marks, LocalDate birthDate) {
		this.student_id = student_id;
		this.course = course;
		this.name = name;
		this.marks = marks;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", course=" + course + ", name=" + name + ", marks=" + marks
				+ ", birthDate=" + birthDate + "]";
	}

	

}
