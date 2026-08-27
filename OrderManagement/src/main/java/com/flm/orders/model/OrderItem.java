package com.flm.orders.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderItemId;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	private long productId;
	
	private int quantity;
	
	private double price;

	public OrderItem(Order order, long productId, int quantity, double price) {
		super();
		this.order = order;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderItem(long productId, int quantity, double price) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	
}
