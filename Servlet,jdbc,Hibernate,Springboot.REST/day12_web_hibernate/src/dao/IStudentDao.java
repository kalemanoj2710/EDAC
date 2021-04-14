package dao;

import java.util.List;

import pojos.Student;

public interface IStudentDao {
//student admission with course title n basic student details (name , email)
	String admitStudent(Student student,String courseTitle);
	//cancel admission
	String cancelAdmission(String courseName,int studentId);
	String admitStudentWithCompleteDetails(Student student,int courseId);	
	//add a method to fetch student details enrolled in a specified course name
	List<Student> getStudentDetailsByCourseName(String courseName);
}
