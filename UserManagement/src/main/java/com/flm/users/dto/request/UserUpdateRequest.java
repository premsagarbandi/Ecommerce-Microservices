package com.flm.users.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {
	
	private String userName;
	
	private String email;
	
	private String password;
	
	private String phoneNumber;
	
	private AddressUpdateRequest address;
	
}
