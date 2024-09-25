package com.microservices.product.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductRequest(UUID id, String name, String description, BigDecimal price) {

}
