package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
