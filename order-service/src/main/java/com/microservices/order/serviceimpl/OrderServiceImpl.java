package com.microservices.order.serviceimpl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.microservices.order.client.InventoryClient;
import com.microservices.order.dto.OrderRequest;
import com.microservices.order.entity.Order;
import com.microservices.order.repository.OrderRepository;
import com.microservices.order.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepo;
	private final InventoryClient inventoryClient;
	
	public void placeOrder(OrderRequest orderRequest) {
		
		boolean isProductAvailable = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
		
		if(isProductAvailable) {
			Order order = new Order();
			order.setOrderNumber(UUID.randomUUID().toString());
			order.setPrice(orderRequest.price());
			order.setSkuCode(orderRequest.skuCode());
			order.setQuantity(orderRequest.quantity());
			orderRepo.save(order);
		} else {
			throw new RuntimeException("Product "+orderRequest.skuCode()+" is out of stock");
		}
		
		
	}

}
