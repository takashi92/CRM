package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpdev.salesmanagement.entities.ProductDetail;
import com.lpdev.salesmanagement.entities.ProductDetailId;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, ProductDetailId> {

}
