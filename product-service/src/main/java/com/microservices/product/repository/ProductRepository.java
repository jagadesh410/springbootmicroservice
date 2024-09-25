package com.microservices.product.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, UUID>{

}
