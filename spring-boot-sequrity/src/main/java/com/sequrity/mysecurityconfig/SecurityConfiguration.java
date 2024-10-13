package com.sequrity.mysecurityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.sequrity.services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests((authorize) -> {
            authorize.requestMatchers("signin").permitAll()
                    .requestMatchers("/public/**").hasRole("USER")
                    .requestMatchers("/users/**").hasRole("ADMIN")
                    .anyRequest().authenticated();
        }).formLogin(login -> login.loginPage("/signin")
        		.loginProcessingUrl("/dologin")
        		.defaultSuccessUrl("/users/"));
		return http.build();

	}

//	@Bean
//	public UserDetailsService userDetailsService(AuthenticationManagerBuilder auth) { 
//		UserDetails user = User.builder().username("test").password(this.passwordEncoder().encode("123")).roles("USER")
//				.build();
//		UserDetails admin = User.builder().username("admin").password(this.passwordEncoder().encode("123"))
//				.roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(user, admin);
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
		
		return configuration.getAuthenticationManager();
		
//		try {
//			auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return new CustomUserDetailService();
	}


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}


}