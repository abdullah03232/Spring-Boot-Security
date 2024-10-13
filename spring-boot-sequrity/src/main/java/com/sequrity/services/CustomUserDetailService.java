package com.sequrity.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sequrity.models.CustomUserDetails;
import com.sequrity.models.User;
import com.sequrity.repositry.UserRepositry;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	UserRepositry userRepositry;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepositry.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		//Set<GrantedAuthority> set = user.getRole().
		Set<String> set = new HashSet<String>();
		set.add(user.getRole());
		
		Set<GrantedAuthority> authorities = null;
		
		
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), null);
	}
	
	
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = this.userRepositry.findByUsername(username);
//		if(user==null) {
//		throw new UsernameNotFoundException("USER NOT FOUND");	
//		}
//		return new CustomUserDetails(user);
//	}

}
