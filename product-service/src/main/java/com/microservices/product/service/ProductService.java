package com.microservices.product.service;

import java.util.List;

import com.microservices.product.dto.ProductRequest;
import com.microservices.product.dto.ProductResponse;
import com.microservices.product.entity.Product;

public interface ProductService {

	ProductResponse addProduct(ProductRequest productRequest);

	List<ProductResponse> getProducts();

}
