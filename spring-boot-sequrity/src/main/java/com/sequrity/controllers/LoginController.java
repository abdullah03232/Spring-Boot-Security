package com.sequrity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/signin")
	public String signIn() {
		return "login.html";
	}
}
