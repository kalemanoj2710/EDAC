package dao;

import java.util.List;

import pojos.Course;

public interface ICourseDao {
	String launchNewCourse(Course c);// c : transient
	String cancelCourse(int courseId);
	Course getCourseDetails(String courseName);
	//add a method for getting all course names
	List<String> fetchAllCourseNames();
}
