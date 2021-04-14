package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICoursesRepository;
import com.app.pojos.Course;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private ICoursesRepository repo;
	
	@Override
	public List<Course> listAllCourses() {
		
		return repo.findAll();
	}

	@Override
	public Course findCourseById(int id) {

		return repo.findByCourseid(id);
	}

	@Override
	public void deleteCouse(Course c) {

		repo.delete(c);
	}

}
