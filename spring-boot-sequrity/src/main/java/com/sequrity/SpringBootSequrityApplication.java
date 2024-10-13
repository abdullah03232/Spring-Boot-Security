package com.sequrity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sequrity.models.User;
import com.sequrity.repositry.UserRepositry;

@SpringBootApplication
public class SpringBootSequrityApplication implements CommandLineRunner{
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private UserRepositry repositry;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSequrityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("abdullah");
		user.setPassword(this.encoder.encode("admin"));
		user.setEmail("abdul@gmail.com");
		user.setRole("NORMAL");
		this.repositry.save(user);
		
		User user1 = new User();
		user1.setUsername("zaid");
		user1.setPassword(this.encoder.encode("zaid"));
		user1.setEmail("zaid@gmail.com");
		user1.setRole("ADMIN");
		this.repositry.save(user1);
		
		User user3 = new User();
		user3.setUsername("rizwan");
		user3.setPassword(this.encoder.encode("rizwan"));
		user3.setEmail("rizwan@gmail.com");
		user3.setRole("ADMIN");
		this.repositry.save(user3);
		
		
	}

}
