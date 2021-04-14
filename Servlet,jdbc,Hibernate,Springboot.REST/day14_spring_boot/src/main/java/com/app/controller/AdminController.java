package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.IVendorService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	//dependency : Vendor service i/f
	@Autowired
	private IVendorService vendorService;
	
	public AdminController() {
		System.out.println("in ctor of "+getClass().getName());
	}
	//add a req handling method to show main admin page , displaying CRUD options
	@GetMapping("/list")
	public String showVendorList(Model map)
	{
		System.out.println("in show vendor list");
		//invoke service latyer method to get all vendors list n save it as model attribute (since using forward
		//to navigate the clnt to the view layer
		map.addAttribute("vendor_list",vendorService.getAllVendors());
		return "/admin/list";//actual view Name by V.R : /WEB-INF/views/admin/list.jsp		
	}
}
