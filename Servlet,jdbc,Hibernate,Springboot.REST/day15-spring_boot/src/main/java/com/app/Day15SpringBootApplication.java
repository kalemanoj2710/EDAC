package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"dependent,dependency"})
//@EntityScan(basePackages = "pojos")
public class Day15SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day15SpringBootApplication.class, args);
	}

}
