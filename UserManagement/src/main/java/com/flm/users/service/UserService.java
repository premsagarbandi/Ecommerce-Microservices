package com.flm.users.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flm.users.dto.request.UserCreateRequest;
import com.flm.users.dto.request.UserUpdateRequest;
import com.flm.users.dto.response.UserResponse;

@Service
public interface UserService {

	public UserResponse saveUser(UserCreateRequest userCreateRequest);
	
	public List<UserResponse> getAllUsers();
	
	public UserResponse getUserById(long userId);
	
	public UserResponse update(long userId, UserUpdateRequest userUpdateRequest);
}
