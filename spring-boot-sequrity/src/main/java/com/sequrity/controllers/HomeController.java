package com.sequrity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public")
public class HomeController {

	@GetMapping("/home")
	public String homePage() {
		return "This is home page";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "This is Login page";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "This is Register page";
	}
	
}
