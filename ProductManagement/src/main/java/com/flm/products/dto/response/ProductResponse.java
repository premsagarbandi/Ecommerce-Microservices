package com.flm.products.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

	private long productId;
	private String productName;
	private String description;
	private String brand;
	private double price;
	private double rating;

}
