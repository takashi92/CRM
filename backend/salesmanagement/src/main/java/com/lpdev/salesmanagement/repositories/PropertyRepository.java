package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpdev.salesmanagement.entities.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, String> {
	
}
