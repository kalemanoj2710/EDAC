package com.app.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Role;
import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Controller // mandatory
@RequestMapping("/user") // optional
public class UserController {
	// dependency
	@Autowired
	private IVendorService vendorService;

	public UserController() {
		System.out.println("in ctor of " + getClass().getName() + " " + vendorService);
	}

	@PostConstruct
	public void anyInit() {
		System.out.println("in init of  " + getClass().getName() + " " + vendorService);
	}

	// add request handling method for : showing the login form
	@GetMapping("/login")
	// Key : /user/login: method=get
	// Value : com.app.controller.UserController.showLoginForm
	public String showLoginForm() {
		System.out.println("in show login form ");
		return "/user/login";// Actual view name : /WEB-INF/views/user/login.jsp

	}

	// add a req handling method to process the form
	// Key : /user/login: method=post
	// Value : com.app.controller.UserController.processLoginForm
	@PostMapping("/login") // @PostMapping => @RequestMapping: method=post
	public String processLoginForm(@RequestParam String email, @RequestParam String password, 
			Model modelMap,HttpSession hs) {
		System.out.println("in process login form " + email + " " + password);
		try {
			// invoke service layer method for B.L
			Vendor user = vendorService.authenticateUser(email, password);
			
			//=> valid login 
			//save validated user details under session scope
			hs.setAttribute("user_details",user);
			hs.setAttribute("message", user.getUserRole()+" ,  "+user.getName()+" logged in successfully...");
			//, check user's role
			if(user.getUserRole().equals(Role.ADMIN)) //admin has logged in
				return "redirect:/admin/list";
			
			if(user.getUserRole().equals(Role.VENDOR)) //vendor has logged in
				return "redirect:/vendor/details";
	
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			// add err mesg as the model attribute
			modelMap.addAttribute("message", "Invalid Login ,Please retry!!!!");
			// => invalid login
			return "/user/login";// V.R --> /WEB-INF/views/user/login.jsp
		}

		return "/vendor/details";// Actual view name : /WEB-INF/views/vendor/details.jsp
	}
}
