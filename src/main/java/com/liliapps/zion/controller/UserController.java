package com.liliapps.zion.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liliapps.zion.model.User;
import com.liliapps.zion.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Value("${app.access.key}")
    private String key;
	
	Random rnd = new Random();
	
	@RequestMapping(value = "/new", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> newUser(@RequestHeader("key") String valid) {
		
		if (!valid.contentEquals(key)) {
			return new ResponseEntity<Object>("Fatal Error", HttpStatus.BAD_REQUEST);
		}
		
		boolean notFound = false;
		String username = "";

		while (!notFound) {
			username = "User" + rnd.nextInt(99999999);
			if (userRepository.usernameExist(username) == null) {
				notFound = true;
			}
		}
		
		User user = new User();
		user.setUsername(username);
		user = userRepository.saveAndFlush(user);
		
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/find/{idUser:.*}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getUser(@PathVariable Long idUser) {		
		return new ResponseEntity<Object>(userRepository.findById(idUser), HttpStatus.OK);
	}

}
