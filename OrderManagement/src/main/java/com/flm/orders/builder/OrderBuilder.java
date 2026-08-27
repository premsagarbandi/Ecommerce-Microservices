package com.flm.orders.builder;

import java.time.LocalDateTime;
import java.util.List;

import com.flm.orders.dto.request.OrderCreateRequest;
import com.flm.orders.dto.request.OrderItemCreateRequest;
import com.flm.orders.dto.request.OrderItemUpdateRequest;
import com.flm.orders.dto.response.OrderItemResponse;
import com.flm.orders.dto.response.OrderResponse;
import com.flm.orders.model.Order;
import com.flm.orders.model.OrderItem;

public class OrderBuilder {

	public static Order buildOrderFromOrderCreateRequest(OrderCreateRequest orderCreateRequest) {
		
		List<OrderItem> orderItems = orderCreateRequest
										.getOrderItems()
										.stream()
										.map(OrderBuilder::buildOrderItemFromOrderItemCreateRequest)
										.toList();
		Order order = Order
						.builder()
						.userId(orderCreateRequest.getUserId())
						.status(orderCreateRequest.getStatus())
						.orderDate(LocalDateTime.now())
						.totalPrice(calculateTotalPrice(orderItems))
						.orderItems(	orderItems)
						.build();
		linkOrderItems(order);
		
		return order;
		
	}
	
	public static OrderItem buildOrderItemFromOrderItemCreateRequest(OrderItemCreateRequest orderItemCreateRequest) {
		
		return OrderItem.builder()
						.productId(orderItemCreateRequest.getProductId())
						.quantity(orderItemCreateRequest.getQuantity())
						.price(orderItemCreateRequest.getPrice())
						.build();
				
		
	}
	
	public static OrderItem buildOrderItemFromOrderItemUpdateRequest(OrderItemUpdateRequest orderItemUpdateRequest) {
		
		return OrderItem.builder()
						.productId(orderItemUpdateRequest.getProductId())
						.quantity(orderItemUpdateRequest.getQuantity())
						.price(orderItemUpdateRequest.getPrice())
						.build();
		
	}
	
	public static OrderResponse buildOrderResponseFromOrder(Order order) {
		
		List<OrderItemResponse> orderItemResponses = order
													.getOrderItems()
													.stream()
													.map(OrderBuilder::buildOrderItemResponseFromOrder)
													.toList();
		return OrderResponse.builder()
							.orderId(order.getOrderId())
							.userId(order.getUserId())
							.totalPrice(order.getTotalPrice())
							.status(order.getStatus())
							.orderDate(order.getOrderDate())
							.orderItems(orderItemResponses)
							.build();
	}
	
	public static OrderItemResponse buildOrderItemResponseFromOrder(OrderItem orderItem){
		
		return OrderItemResponse.builder()
								.orderItemId(orderItem.getOrderItemId())
								.orderId(orderItem.getOrder().getOrderId())
								.productId(orderItem.getProductId())
								.quantity(orderItem.getQuantity())
								.price(orderItem.getPrice())
								.build();
		
	}
	
	public static double calculateTotalPrice(List<OrderItem> orderItems) {
		
		return orderItems
				.stream()
				.mapToDouble(item -> item.getPrice() * item.getQuantity())
				.sum();
	}
	
	public static void linkOrderItems(Order order) {
		
		order.getOrderItems().forEach(item -> item.setOrder(order));
	}
}
