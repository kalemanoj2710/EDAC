package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.ICourseService;

@Controller
@RequestMapping("/courses")
public class CoursesController {

	@Autowired
	private ICourseService repo;
	
	public CoursesController() {
		System.out.println("In CoursesController");
	}
	
	@GetMapping("/list")
	public String showCourseListPage(Model map){
		
		map.addAttribute("courses_list", repo.listAllCourses());
		return "/courses/list";
	}
	
	@GetMapping("/delete")
	public String deleteCourse(@RequestParam int bid) {
		repo.deleteCouse(repo.findCourseById(bid));
		return "redirect:/courses/list";
	}

}
