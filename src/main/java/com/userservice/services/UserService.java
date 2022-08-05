package com.userservice.services;

import com.userservice.models.User;

public interface UserService {

	// creating user
	public User createUser(User user) throws Exception;

	//get user by username
	public User getUserByUserName(String userName) throws Exception;

	//delete user by id
	public void deleteUserById(Integer uId);

}
