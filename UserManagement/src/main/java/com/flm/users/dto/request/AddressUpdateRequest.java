package com.flm.users.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressUpdateRequest {

	private String street;
	
	private String city;
	
	private String pincode;
	
	private String state;
	
	private String country;
}
