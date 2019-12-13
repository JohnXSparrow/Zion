package com.liliapps.zion.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liliapps.zion.model.User;
import com.liliapps.zion.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value = "/new_user", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> newUser() {	
		boolean notFound = false;		
		String username = "";
		Random rnd = new Random();

		while (!notFound) {		    
			username = "User" + rnd.nextInt(9999999);
			if (userRepository.usernameExist(username) == null) {
				notFound = true;				
			}
		}		
		
		User user = new User();
		user.setUsername(username);
		
		user = userRepository.saveAndFlush(user);
		
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}

}
