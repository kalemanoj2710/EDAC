package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //mandatory
public class HelloController {
	public HelloController() {
		System.out.println("in ctor of "+getClass().getName());
	}
	//add request handling method
	@RequestMapping("/hello")
	public String sayHello()
	{
		System.out.println("in say hello");
		return "/welcome";
	}

}
