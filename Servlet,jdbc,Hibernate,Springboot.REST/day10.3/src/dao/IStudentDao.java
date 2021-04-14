package dao;

import pojos.Student;

public interface IStudentDao {
//student admission
	String admitStudent(Student student,String courseTitle);
	//cancel admission
	String cancelAdmission(String courseName,int studentId);
	
}
