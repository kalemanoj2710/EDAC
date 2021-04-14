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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(length = 40)
	@Size(max = 40, message = "Size should be less than 40 characters")
	private String name;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	List<Student> students = new ArrayList<>();

	public Course(Integer id, @NotBlank @Size(max = 40, message = "Size should be less than 40 characters") String name,
			List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
	}

	public Course() {
		// TODO Auto-generated constructor stub
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	public void addStudent(Student s) {
		students.add(s);
		s.setCourse(this);
	}
	
}
