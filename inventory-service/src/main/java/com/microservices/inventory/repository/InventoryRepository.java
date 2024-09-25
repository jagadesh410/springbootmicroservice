package com.microservices.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.inventory.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);

}
