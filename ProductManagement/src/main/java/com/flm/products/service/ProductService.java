package com.flm.products.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flm.products.dto.request.ProductCreateRequest;
import com.flm.products.dto.request.ProductUpdateRequest;
import com.flm.products.dto.response.ProductResponse;

@Service
public interface ProductService {

	public ProductResponse save(ProductCreateRequest productCreateRequest);
	public List<ProductResponse> getAllProducts();
	public ProductResponse getProductByID(long productId);
	public ProductResponse update(long productId, ProductUpdateRequest productUpdateRequest);
	public void delete(long productId);
}
