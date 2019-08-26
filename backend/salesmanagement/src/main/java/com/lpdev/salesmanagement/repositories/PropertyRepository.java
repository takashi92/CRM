package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer> {

	public Property findByName(String name);
	
}
