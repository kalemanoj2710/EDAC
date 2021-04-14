package com.app.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.pojos.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	private List<Product> products;

	public ProductController() {
		System.out.println("in ctor of " + getClass().getName());
		products = Arrays.asList(new Product(1, "biscuits", 100, LocalDate.parse("2021-12-23")),
				new Product(2, "oil", 300, LocalDate.parse("2021-10-23")),
				new Product(3, "wheat", 110, LocalDate.parse("2021-11-23")),
				new Product(4, "fruits", 70, LocalDate.parse("2021-09-23")));
	}

	// add req handling method for demo of @ResponseBody
	@GetMapping
	public @ResponseBody List<Product> getAllProducts() {
		System.out.println("in get all products");
		return products;
	}

	// /products/10/bread/50/2021-03-04'
	// add another method to demo @ResponseBody n PathVar
	// Just a simple demo! In RESTful web service : will be handeled by POST
	@GetMapping("/{pid}/{pName}/{price}/{exp_date}")
	public @ResponseBody Product createProduct(@PathVariable int pid, @PathVariable String pName,
			@PathVariable double price,
			@PathVariable(name = "exp_date") 
	@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate expDate) {
		System.out.println("in create product " + pid + " " + expDate);
		return new Product(pid, pName, price, expDate);
	}
}
