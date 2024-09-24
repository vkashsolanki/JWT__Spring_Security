package com.jwt.security.service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.security.entity.User;

@Service
public class UserService {
	
	private List<User> users = new ArrayList<>();


	public UserService() {
		
	
		users.add(new User(UUID.randomUUID().hashCode(),"vikash","vikash@gmail.com"));
		users.add(new User(UUID.randomUUID().hashCode(),"lalan","lalan@gmail.com"));
		users.add(new User(UUID.randomUUID().hashCode(),"komal","komal@gmail.com"));
		users.add(new User(UUID.randomUUID().hashCode(),"shaym","shaym@gmail.com"));
		users.add(new User(UUID.randomUUID().hashCode(),"ram","ram@gmail.com"));
	
	}
	
	public List<User> getUser(){
		return this.users;
	}
	
	
	
	
	

}
