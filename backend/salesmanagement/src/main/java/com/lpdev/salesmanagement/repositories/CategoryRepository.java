package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
