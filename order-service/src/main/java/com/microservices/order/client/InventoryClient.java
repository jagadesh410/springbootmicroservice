package com.microservices.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory", url = "${inventoryclient.url}")
public interface InventoryClient {
	
	@RequestMapping(method = RequestMethod.GET, value="/inventory")
	boolean isInStock(@RequestParam String skuCode, @RequestParam int quantity);
	
}
