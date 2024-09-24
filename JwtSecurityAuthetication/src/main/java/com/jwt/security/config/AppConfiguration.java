package com.jwt.security.config;



import java.security.Principal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
public class AppConfiguration {
	
	@Bean
	public UserDetailsService userDetailsService() {
		// there are two user 
		UserDetails userDetails1 = User.builder().username("prath").password(passwordEncoder().encode("prath")).roles("admin").build();
		UserDetails userDetails2 = User.builder().username("prath1").password(passwordEncoder().encode("prath1")).roles("admin1").build();
		UserDetails userDetails3 = User.builder().username("prath2").password(passwordEncoder().encode("prath2")).roles("admin2").build();
		
		return new InMemoryUserDetailsManager(userDetails1,userDetails2,userDetails3);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
		
	}

	

}
