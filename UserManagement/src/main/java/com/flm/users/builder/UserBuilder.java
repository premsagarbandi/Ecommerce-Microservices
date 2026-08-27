package com.flm.users.builder;

import com.flm.users.dto.request.AddressUpdateRequest;
import com.flm.users.dto.request.UserCreateRequest;
import com.flm.users.dto.request.UserUpdateRequest;
import com.flm.users.dto.response.UserResponse;
import com.flm.users.model.Address;
import com.flm.users.model.User;

public class UserBuilder {

	static AddressBuilder addressBuilder;
	
	public static User buildUserFromUserCreateRequest(UserCreateRequest userCreateRequest) {
		
		return User
					.builder()
					.userName(userCreateRequest.getUserName())
					.email(userCreateRequest.getEmail())
					.password(userCreateRequest.getPassword())
					.phoneNumber(userCreateRequest.getPhonenumber())
					.address(addressBuilder.buildAddressFromAddressCreateRequest(userCreateRequest.getAddress()))
					.build();
	}
	
	public static UserResponse buildUserResponseFromUser(User user) {
		
		return UserResponse
						.builder()
						.userId(user.getUserId())
						.userName(user.getUserName())
						.email(user.getEmail())
						.phoneNumber(user.getPhoneNumber())
						.address(addressBuilder.buildAddressResponseFromAddress(user.getAddress()))
						.build();
		
	}
	
	public static User buildUserFromUserUpdateRequest(User existingUser, UserUpdateRequest userUpdateRequest) {
		
		return User.builder()
					.userId(existingUser.getUserId())
					.userName(userUpdateRequest.getUserName())
					.email(userUpdateRequest.getEmail())
					.password(userUpdateRequest.getPassword())
					.phoneNumber(userUpdateRequest.getPhoneNumber())
					.address(addressBuilder.buildAddressFromAddressUpdateRequest(existingUser.getAddress(), userUpdateRequest.getAddress()))
					.build();
		
	}
	
	
	
}
