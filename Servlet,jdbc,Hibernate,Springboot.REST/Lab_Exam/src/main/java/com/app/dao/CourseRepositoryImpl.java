package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Course;

@Repository
public class CourseRepositoryImpl implements ICourseRepository {

	@Autowired
	private EntityManager mgr;
	
	@Override
	public List<Course> getAllCourses() {
		String jpql = "select c from Course c";
		List<Course> courses = mgr.createQuery(jpql, Course.class).getResultList();
		return courses;
	}

	@Override
	public Course getCourseById(int courseId) {
		String jpql = "select c from Course c left join fetch c.students where c.id=:courseId";
		Course c = mgr.createQuery(jpql, Course.class).setParameter("courseId", courseId).getSingleResult();
		return c;
	}

	@Override
	public String deleteCourse(Course course) {
		String message = "Course was successfully deleted";
		mgr.remove(course);
		return message;
	}

	@Override
	public String addStudent(Course course) {
		String message = "Student was successfully added";
		mgr.persist(course);
		return message;
	}

}
