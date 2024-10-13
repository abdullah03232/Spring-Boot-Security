package com.sequrity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sequrity.models.User;
import com.sequrity.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/")
	public List<User> getAllUsers(){
		return this.userServices.getAllUsers();
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userServices.getUser(username);
	}
	
	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		System.out.println(user.toString());
		return this.userServices.addUser(user);
	}

}
