package com.jwt.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.jwt.example.security.JwtAuthenticationEntryPoint;
import com.jwt.example.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {
	
	 @Autowired
	 private JwtAuthenticationEntryPoint point;
	 @Autowired
	 private JwtAuthenticationFilter filter;
	 
	 

}
