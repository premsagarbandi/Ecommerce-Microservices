package com.flm.products.builder;

import com.flm.products.dto.request.ProductCreateRequest;
import com.flm.products.dto.response.ProductResponse;
import com.flm.products.model.Product;

public class ProductBuilder {

	public static Product buildProductFromProductCreateRequest(ProductCreateRequest productCreateRequest) {
		
			return Product.builder()
					.productName(productCreateRequest.getProductName())
					.brand(productCreateRequest.getBrand())
					.description(productCreateRequest.getDescription())
					.price(productCreateRequest.getPrice())
					.rating(productCreateRequest.getRating())
					.build();
		
	}
	
	public static ProductResponse buildProductResponseFromProduct(Product product) {
		
		return ProductResponse.builder()
					.productId(product.getProductId())
					.productName(product.getProductName())
					.brand(product.getBrand())
					.description(product.getDescription())
					.price(product.getPrice())
					.rating(product.getRating())
					.build();
	}
	
	public static Product buildProductFromProductUpdateRequest(Product existingProduct) {
		
		return Product
				.builder()
				.productId(existingProduct.getProductId())
				.productName(existingProduct.getProductName())
				.description(existingProduct.getDescription())
				.brand(existingProduct.getBrand())
				.price(existingProduct.getPrice())
				.rating(existingProduct.getRating())
				.build();
	}
}
