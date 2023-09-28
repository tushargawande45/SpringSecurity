package com.jwt.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =  User.builder().username("Tushar").password(passwordEncoder().encode("Tg@123")).roles("ADMIN").build();
		UserDetails user1 =  User.builder().username("Mahesh").password(passwordEncoder().encode("Mk@123")).roles("ADMIN").build();
		
		return new InMemoryUserDetailsManager(user,user1);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
}
