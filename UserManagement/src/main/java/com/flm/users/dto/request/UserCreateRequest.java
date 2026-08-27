package com.flm.users.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

	private String userName;
	
	private String email;
	
	private String password;
	
	private String phonenumber;
	
	private AddressCreateRequest address;
	
}
