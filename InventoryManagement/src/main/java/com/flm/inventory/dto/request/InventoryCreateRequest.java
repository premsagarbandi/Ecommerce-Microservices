package com.flm.inventory.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryCreateRequest {

	private long productId;
	private int availableQuantity;
	private int reserveQuantity;
	private String warehouse;
	private String createdBy;
}
