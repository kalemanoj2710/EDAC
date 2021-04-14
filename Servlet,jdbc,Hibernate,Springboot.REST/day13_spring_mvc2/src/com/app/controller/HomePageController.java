package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor "+getClass().getName());
	}
	//add req handling method for displaying index page
	@RequestMapping("/")
	public String provideHomePage()
	{
		System.out.println("in provide hm page");
		return "/index";//absolute view name : /WEB-INF/views/index.jsp
	}

}
