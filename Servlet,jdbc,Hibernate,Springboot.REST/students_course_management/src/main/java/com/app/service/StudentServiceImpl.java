package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStudentRepository;
import com.app.pojos.Student;


@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentRepository repo;
	
	@Override
	public Student insertStudent(Student s) {
		Student student = repo.save(s);
		return student;
	}

}
