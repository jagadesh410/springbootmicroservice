package com.microservices.product.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.product.dto.ProductRequest;
import com.microservices.product.dto.ProductResponse;
import com.microservices.product.entity.Product;
import com.microservices.product.repository.ProductRepository;
import com.microservices.product.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepo;

	@Override
	public ProductResponse addProduct(ProductRequest productRequest) {
		// TODO Auto-generated method stub
		Product product = Product.builder()
				.name(productRequest.name())
				.description(productRequest.description())
				.price(productRequest.price())
				.build();
		productRepo.save(product);
		log.info("Product cretaed successfully");
		return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}

	@Override
	public List<ProductResponse> getProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll()
				.stream()
				.map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
				.toList();
	}

}
