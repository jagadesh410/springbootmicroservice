package com.microservices.inventory.serviceimpl;

import org.springframework.stereotype.Service;

import com.microservices.inventory.repository.InventoryRepository;
import com.microservices.inventory.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
	
	private final InventoryRepository inventoryRepository;

	@Override
	public boolean isInStock(String skuCode, int quantity) {
		// TODO Auto-generated method stub
		return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
	}

}
