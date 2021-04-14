package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("In HomePageController");
	}
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("In showHomePage");
		return "/index";
	}
}
