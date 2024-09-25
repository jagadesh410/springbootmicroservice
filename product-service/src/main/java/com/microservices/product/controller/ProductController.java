package com.microservices.product.controller;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.product.dto.ProductRequest;
import com.microservices.product.dto.ProductResponse;
import com.microservices.product.entity.Product;
import com.microservices.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;
	
	@PostMapping("/addProduct")
	public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {
		
		ProductResponse productResponse = productService.addProduct(productRequest);
		return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("/getProducts")
	public ResponseEntity<List<ProductResponse>> getAllProducts() {
		List<ProductResponse> productResponse = productService.getProducts();
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}

}
