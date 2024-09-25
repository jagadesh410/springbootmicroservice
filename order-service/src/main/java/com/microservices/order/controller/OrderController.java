package com.microservices.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.order.dto.OrderRequest;
import com.microservices.order.serviceimpl.OrderServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {
		orderServiceImpl.placeOrder(orderRequest);
		return new ResponseEntity<>("Order Placed Successfully", HttpStatus.OK);
	}

}
