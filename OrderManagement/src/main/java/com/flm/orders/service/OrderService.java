package com.flm.orders.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flm.orders.dto.request.OrderCreateRequest;
import com.flm.orders.dto.request.OrderUpdateRequest;
import com.flm.orders.dto.response.OrderResponse;



@Service
public interface OrderService {

	public OrderResponse saveOrder(OrderCreateRequest orderCreateRequest);
	public List<OrderResponse> getAllOrders();
	public OrderResponse getOrderbyId(long orderId);
	public OrderResponse update(long orderId, OrderUpdateRequest orderUpdateRequest);
	public void delete(long orderId);
}
