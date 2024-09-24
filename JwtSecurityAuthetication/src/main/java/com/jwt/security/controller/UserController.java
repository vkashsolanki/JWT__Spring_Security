package com.jwt.security.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.security.entity.User;
import com.jwt.security.service.UserService;

@RestController
@RequestMapping("/autho")
public class UserController {
	@Autowired
	private UserService service;
	@GetMapping("/hi")
	public List<User> gethome() {
		
		service.getUser();
		
		
		return this.service.getUser();
	}
	
	
	@GetMapping("/currentuser")
	@ResponseBody
	public String getLoggedInUser(Principal principal)
	{
		return principal.getName();
		
	}
	

}
