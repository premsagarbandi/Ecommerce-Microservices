package com.flm.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.flm.users.dto.request.UserCreateRequest;
import com.flm.users.dto.request.UserUpdateRequest;
import com.flm.users.dto.response.UserResponse;
import com.flm.users.service.impl.UserServiceImpl;



@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServiceImpl userService;
	
	@PostMapping()
	public UserResponse saveUser(@RequestBody UserCreateRequest userCreateRequest) {
		
		UserResponse saveUser = userService.saveUser(userCreateRequest);
		
		return saveUser;
	}
	
	@GetMapping
	public List<UserResponse> getAllUsers(){
		
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public UserResponse getUserById(@PathVariable long userId) {
		
		return userService.getUserById(userId);
		
	}
	
	@PutMapping("/{userId}")
	public UserResponse updateUser(@PathVariable long userId, @RequestBody UserUpdateRequest userUpdateRequest) {
		
		return userService.update(userId, userUpdateRequest);
		
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable long userId) {
		
		userService.delete(userId);
	}
}