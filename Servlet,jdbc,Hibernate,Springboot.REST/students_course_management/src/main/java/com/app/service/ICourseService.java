package com.app.service;

import java.util.List;

import com.app.pojos.Course;

public interface ICourseService {

	List<Course> listAllCourses();
	Course findCourseById(int id);
	void deleteCouse(Course c);
}
