package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpdev.salesmanagement.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
