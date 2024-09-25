package com.microservices.inventory.service;

public interface InventoryService {
	
	boolean isInStock(String skuCode, int quantity);

}
