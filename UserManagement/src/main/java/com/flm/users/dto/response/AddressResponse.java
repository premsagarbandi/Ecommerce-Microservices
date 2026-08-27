package com.flm.users.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {

	private long addressId;
	
	private String street;
	
	private String city;
	
	private String pincode;
	
	private String state;
	
	private String country;
	
}
