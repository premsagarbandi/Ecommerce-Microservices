package com.flm.orders.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemUpdateRequest {

	private long productId;
	
	private int quantity;
	
	private double price;
}
