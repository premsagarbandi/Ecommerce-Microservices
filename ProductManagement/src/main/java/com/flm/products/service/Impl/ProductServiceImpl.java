package com.flm.products.service.Impl;

import java.util.List;

import org.apache.commons.lang3.RuntimeEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.products.builder.ProductBuilder;
import com.flm.products.dao.ProductRepository;
import com.flm.products.dto.request.ProductCreateRequest;
import com.flm.products.dto.request.ProductUpdateRequest;
import com.flm.products.dto.response.ProductResponse;
import com.flm.products.model.Product;
import com.flm.products.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	public ProductResponse save(ProductCreateRequest productCreateRequest) {
		
		Product product = ProductBuilder.buildProductFromProductCreateRequest(productCreateRequest);
		
		Product savedProduct = productRepository.save(product);
		
		return ProductBuilder.buildProductResponseFromProduct(savedProduct);
	}

	@Override
	public List<ProductResponse> getAllProducts() {

		return productRepository
								.findAll()
								.stream()
								.map(ProductBuilder::buildProductResponseFromProduct)
								.toList();
	}

	@Override
	public ProductResponse getProductByID(long productId) {
		
		Product product = productRepository
										.findById(productId)
										.orElseThrow(()-> new RuntimeException("Product not found with ID:" + productId));
		return ProductBuilder.buildProductResponseFromProduct(product);
	}

	@Override
	public ProductResponse update(long productId, ProductUpdateRequest productUpdateRequest) {
		
		Product existingProduct = productRepository
									.findById(productId)
									.orElseThrow(()-> new RuntimeException("Product not found with ID: "+ productId));
		Product product = ProductBuilder.buildProductFromProductUpdateRequest(existingProduct);
			
		Product savedProduct = productRepository.save(product);
			
		return ProductBuilder.buildProductResponseFromProduct(savedProduct);
	}

	@Override
	public void delete(long productId) {

		if(!productRepository.existsById(productId)) {
			throw new RuntimeException("Product is not found with ID: " + productId);
		}
		
		productRepository.deleteById(productId);;
	}
	
}
