package com.sequrity.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sequrity.models.User;

public interface UserRepositry extends JpaRepository<User, String>{
public User findByUsername(String username);
}
