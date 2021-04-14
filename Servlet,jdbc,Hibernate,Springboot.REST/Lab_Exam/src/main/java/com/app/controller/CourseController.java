package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Course;
import com.app.pojos.Student;
import com.app.service.ICourseService;

@Controller
@Validated
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	ICourseService service;
	
	@GetMapping("/courses")
	public String getAllCourses(ModelMap map) {
		List<Course> courses = service.getAllCourses();
		map.addAttribute("courses", courses);
		return("/course/courses");
	}
	
	@GetMapping("/addstudent")
	public String addStudent(@RequestParam int courseId, ModelMap map) {
		Student student = new Student();
		map.addAttribute("student", student);
		map.addAttribute("courseId", courseId);
		return "/course/addstudent";
	}
	
	@PostMapping("/addstudent")
	public String saveStudent(@Valid @ModelAttribute(name = "student") Student s, @RequestParam int courseId, 
			RedirectAttributes flashMap, BindingResult bindings) {
		if(bindings.hasErrors()) {
			flashMap.addAttribute("student", s);
			flashMap.addAttribute("courseId", courseId);
			return "/course/addstudent";
		}
		Course c = service.getCourseById(courseId);
		c.addStudent(s);
		String message = service.addStudent(c);
		flashMap.addFlashAttribute("response", message);
		return "redirect:/course/courses";
	}
	
	@GetMapping("/delete")
	public String addStudent(@RequestParam int courseId, RedirectAttributes flashMap) {
		System.out.println("In save " + courseId);
		Course c = service.getCourseById(courseId);
		String message = service.deleteCourse(c);
		flashMap.addFlashAttribute("response", message);
		return "redirect:/course/courses";
	}

}
