package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

	public Brand findByName(String name);

}
