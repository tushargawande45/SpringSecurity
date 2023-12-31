package com.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity

public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/signin").permitAll()
				.antMatchers("/public/**").hasRole("NORMAL")
				.antMatchers("/users/**").hasRole("ADMIN")
				.anyRequest()
				.authenticated()
				.and()
//				.httpBasic();  ---> This is for Basic Authorization
				.formLogin()    //--> This is for Form Based Authorization
				.loginPage("/signin")
				.loginProcessingUrl("/doLogin")
				.defaultSuccessUrl("/users/");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("John").password(this.passwordEncoder().encode("John@123")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("Tushar").password(this.passwordEncoder().encode("Tg@321")).roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
		
	}
	
	
	

}
