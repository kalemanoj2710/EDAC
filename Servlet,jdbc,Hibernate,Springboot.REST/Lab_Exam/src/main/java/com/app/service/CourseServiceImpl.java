package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICourseRepository;
import com.app.pojos.Course;


@Service
@Transactional
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private ICourseRepository dao;
	
	@Override
	public List<Course> getAllCourses() {
		return dao.getAllCourses();
	}

	@Override
	public Course getCourseById(int courseId) {
		return dao.getCourseById(courseId);
	}

	@Override
	public String deleteCourse(Course course) {
		return dao.deleteCourse(course);
	}

	@Override
	public String addStudent(Course course) {
		return dao.addStudent(course);
	}

}
