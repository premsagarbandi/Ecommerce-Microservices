package com.flm.users.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

	private long userId;
	
	private String userName;
	
	private String email;
	
	private String phoneNumber;
	
	private AddressResponse address;
	
}
