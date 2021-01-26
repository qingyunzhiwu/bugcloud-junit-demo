package com.bugcloud.junit.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugcloud.junit.demo.model.User;
import com.bugcloud.junit.demo.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public User getOneById(String id) {
		return userRepository.getOne(id);
	}

	@Override
	public User add(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	public void delete(String id) {
		userRepository.deleteById(id);
	}

	@Override
	public void update(User user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

}
