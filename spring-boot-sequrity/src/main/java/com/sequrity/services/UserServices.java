package com.sequrity.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sequrity.models.User;

@Service
public class UserServices {

	List<User> users = new ArrayList<User>();

	public UserServices() {
//		users.add(new User("imran", "imr123", "imr@gmail.com"));
//		users.add(new User("kaif", "kaif123", "kaif@gmail.com"));

	}
	
	//get all users
	public List<User> getAllUsers(){
		return this.users;
	}
	
	//get single users
	public User getUser(String username) {
		return users.stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	//Add new users
	public User addUser(@RequestBody User user) {
		this.users.add(user);
		System.out.println(users);
		return user;
	}

}
