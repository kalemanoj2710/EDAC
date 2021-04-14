package com.app.dao;

import java.util.List;

import com.app.pojos.Course;

public interface ICourseRepository {

	public List<Course> getAllCourses();
	
	public Course getCourseById(int courseId);
	
	public String deleteCourse(Course course);
	
	public String addStudent(Course course);
}
