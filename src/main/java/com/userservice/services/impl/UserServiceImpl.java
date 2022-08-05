package com.userservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.models.User;

import com.userservice.repo.UserRepository;
import com.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	// creating user
	@Override
	public User createUser(User user/* , Set<UserRole> userRoles */) throws Exception {
		User local = this.userRepository.findByUserName(user.getUserName());
		if (local != null) {
			System.out.println("User is already there");
			throw new Exception("User already present");
		} else {

			local = this.userRepository.save(user);

		}
		return local;
	}

	// get user by username
	@Override
	public User getUserByUserName(String userName) throws Exception {
		User local = this.userRepository.findByUserName(userName);
		if(local==null) {
			System.out.println("User not found");
			throw new Exception("User not found");
		}
		else {
			return local;
		}

	}

	//delete user by id
	@Override
	public void deleteUserById(Integer uId) {
		this.userRepository.deleteById(uId);
		
	}

}
