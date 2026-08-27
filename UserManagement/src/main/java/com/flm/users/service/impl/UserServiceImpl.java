package com.flm.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.users.builder.UserBuilder;
import com.flm.users.dao.UserRepository;
import com.flm.users.dto.request.UserCreateRequest;
import com.flm.users.dto.request.UserUpdateRequest;
import com.flm.users.dto.response.UserResponse;
import com.flm.users.model.User;
import com.flm.users.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserResponse saveUser(UserCreateRequest userCreateRequest) {
		
		User user = UserBuilder.buildUserFromUserCreateRequest(userCreateRequest);
		User savedUser = userRepository.save(user);
		
		UserResponse userResponse = UserBuilder.buildUserResponseFromUser(savedUser);
		
		return userResponse;
	}

	@Override
	public List<UserResponse> getAllUsers() {
		
		return userRepository
							.findAll()
							.stream()
							.map(UserBuilder::buildUserResponseFromUser)
							.toList();
	}

	@Override
	public UserResponse getUserById(long userId) {

		User user = userRepository
							.findById(userId)
							.orElseThrow(()-> new RuntimeException("User not found with the given ID"));
		
							
		return UserBuilder.buildUserResponseFromUser(user);
	}

	@Override
	public UserResponse update(long userId, UserUpdateRequest userUpdateRequest) {
		
		User existingUser = userRepository
								.findById(userId)
								.orElseThrow(() -> new RuntimeException("User not found with the given ID"));
		User user = UserBuilder.buildUserFromUserUpdateRequest(existingUser, userUpdateRequest);
		
		User savedUser = userRepository.save(user);
		
		return UserBuilder.buildUserResponseFromUser(savedUser);
	}

	public void delete(long userId) {
		
		if(!userRepository.existsById(userId)) {
			
			throw new RuntimeException("User not found with id: " + userId);
		}
		
		userRepository.deleteById(userId);
	}
}
