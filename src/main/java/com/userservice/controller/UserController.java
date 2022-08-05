package com.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.models.User;
import com.userservice.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {

		//encoding password with bcryptpassword encoder
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		return this.userService.createUser(user);

	}

	//get user by username
	@GetMapping("/{userName}")
	public User getUserByUserName(@PathVariable("userName") String userName) throws Exception {
		return this.userService.getUserByUserName(userName);
	}
	
	//delete user by id
	@DeleteMapping("/{uId}")
	public void deleteUserById(@PathVariable("uId") Integer uId) {
		this.userService.deleteUserById(uId);
		
	}

}
