package beans;

import java.util.List;

import dao.CourseDaoImpl;

public class CourseBean {
	private CourseDaoImpl courseDao;

	public CourseBean() {
		System.out.println("in ctor of " + getClass().getName());
		// create dao instance
		courseDao = new CourseDaoImpl();
	}
	//add B.L method to get all course names
	public List<String> getAllCourses()
	{
		return courseDao.fetchAllCourseNames();
	}
}
