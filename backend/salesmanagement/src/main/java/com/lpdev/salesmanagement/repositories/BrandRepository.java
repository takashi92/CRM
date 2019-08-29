package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpdev.salesmanagement.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

	public Brand findByName(String name);

}
