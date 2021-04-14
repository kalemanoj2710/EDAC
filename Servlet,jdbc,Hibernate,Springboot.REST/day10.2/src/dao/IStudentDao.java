package dao;

import pojos.Student;

public interface IStudentDao {
//student admission
	String admitStudent(Student student,String courseTitle);
}
