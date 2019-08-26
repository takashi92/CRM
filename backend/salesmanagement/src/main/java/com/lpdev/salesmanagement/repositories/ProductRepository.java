package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
