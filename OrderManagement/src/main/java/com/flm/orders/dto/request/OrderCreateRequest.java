package com.flm.orders.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequest {

	private long userId;
	
	private String status;
	
	private List<OrderItemCreateRequest> orderItems;
	
}
