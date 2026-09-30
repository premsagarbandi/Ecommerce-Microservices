package com.flm.delivery.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

	private long orderId;
	private long userId;
	private String  name;
	private double totalPrice;
	private String status;
	private LocalDateTime orderDate;
	private List<OrderItemResponse> orderItems;
}
