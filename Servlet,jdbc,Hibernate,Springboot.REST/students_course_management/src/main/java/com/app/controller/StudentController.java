package com.app.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Course;
import com.app.pojos.Student;
import com.app.service.ICourseService;
import com.app.service.IStudentService;

import static java.time.LocalDate.parse;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private ICourseService repo;
	
	@Autowired
	private IStudentService repo2;
	
	
	
	public StudentController() {
		System.out.println("In student controller");
	}
	
	@GetMapping("/addmission")
	public String showStudentAdmPage(@RequestParam int bid, Model map,Course course,HttpSession hs) {
		
		course = repo.findCourseById(bid);
		Student s = new Student();
		
		hs.setAttribute("optedCourse", course);
		return "/student/addmission";
	}
	
	@PostMapping("/addmission")
	public String admitStudentPage(Student student,HttpSession hs,Model map) {
		
		Course c = (Course) hs.getAttribute("optedCourse");
//		c.addStudent(student);
		if(student.getDob().isAfter(parse("1990-12-31")) && student.getCgpa() > 7)
		{
			student.setOptedCourse(c);
			repo2.insertStudent(student);
			return "redirect:/courses/list";
		}
		else {
			map.addAttribute("error", "Not elible");
			return "/student/addmission";
		}
	}
}
