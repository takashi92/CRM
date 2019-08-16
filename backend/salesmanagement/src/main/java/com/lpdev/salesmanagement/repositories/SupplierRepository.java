package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
