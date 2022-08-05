package com.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String userName);

}
