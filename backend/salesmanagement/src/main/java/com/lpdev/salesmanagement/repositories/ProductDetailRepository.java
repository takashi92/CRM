package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.ProductDetail;
import com.lpdev.salesmanagement.entities.ProductDetailId;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, ProductDetailId> {

}
