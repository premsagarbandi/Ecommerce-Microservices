package com.flm.orders.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateRequest {

	private long userId;
	
	private double totalprice;
	
	private String status;
	
	private List<OrderItemUpdateRequest> orderItems;
	
}
