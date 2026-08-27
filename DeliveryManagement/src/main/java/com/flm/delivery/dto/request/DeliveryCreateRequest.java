package com.flm.delivery.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryCreateRequest {

	private long orderId;
	
	private String trackingNumber;
	
	private String shippingAddress;
	
	private LocalDate estimatedDeliveryDate;
	
	private String status;
	
}
