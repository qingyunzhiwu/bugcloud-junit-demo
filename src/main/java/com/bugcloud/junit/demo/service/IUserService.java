package com.bugcloud.junit.demo.service;

import java.util.List;

import com.bugcloud.junit.demo.model.User;

public interface IUserService {
	User getOneById(String id);
	
	List<User> getAllUser();
	
	User add(User user);

	void delete(String id);

	void update(User user);
}
