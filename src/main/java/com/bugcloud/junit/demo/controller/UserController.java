package com.bugcloud.junit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bugcloud.junit.demo.model.User;
import com.bugcloud.junit.demo.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable String userId) {
		return ResponseEntity.ok(userId);
	}

	@RequestMapping
	public ResponseEntity<?> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUser());
	}

	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody User user) {
		User newUser = userService.add(user);
		return ResponseEntity.ok(newUser);
	}

	@DeleteMapping("{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable String userId) {
		User user = userService.getOneById(userId);
		if (user == null) {
			throw new RuntimeException("删除的userId=" + userId + "不存在！");
		}
		userService.delete(userId);
		return ResponseEntity.ok(user);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable String userId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "password", required = false) String password) throws Exception {
		if (name == null || "".equals(name)) {
			throw new Exception("参数name不能为空!");
		}
		if (password == null || "".equals(password)) {
			throw new Exception("参数password不能为空!");
		}
		User user = userService.getOneById(userId);
		user.setName(name);
		user.setPassword(password);
		this.userService.update(user);
		return ResponseEntity.ok(user);
	}
}
