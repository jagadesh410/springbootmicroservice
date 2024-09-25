package com.microservices.inventory.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.inventory.serviceimpl.InventoryServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
	
	private final InventoryServiceImpl inventoryServiceImpl;
	
	@GetMapping
	public ResponseEntity<Boolean> isInStock(@RequestParam String skuCode, @RequestParam int quantity) {
		boolean inStock = inventoryServiceImpl.isInStock(skuCode, quantity);
		return new ResponseEntity<>(inStock, HttpStatus.OK);
	}
	

}
