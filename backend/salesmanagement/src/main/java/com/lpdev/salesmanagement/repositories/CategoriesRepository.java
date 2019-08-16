package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

}
