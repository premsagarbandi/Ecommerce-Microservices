package com.flm.delivery.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "deliveries")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long deliveryId;
	
	private long orderId;
	
	private String trackingNumber;
	
	@Column(length = 500)
	private String shippingAddress;
	
	private LocalDate estimatedDeliveryDate;
	
	private LocalDate actualDeliveryDate;
	
	private String status;

	public Delivery(long orderId, String trackingNumber, String shippingAddress, LocalDate estimatedDeliveryDate,
			LocalDate actualDeliveryDate, String status) {
		super();
		this.orderId = orderId;
		this.trackingNumber = trackingNumber;
		this.shippingAddress = shippingAddress;
		this.estimatedDeliveryDate = estimatedDeliveryDate;
		this.actualDeliveryDate = actualDeliveryDate;
		this.status = status;
	}
	
	
}
