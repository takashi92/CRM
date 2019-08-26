package com.lpdev.salesmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.entities.Category;
import com.lpdev.salesmanagement.models.params.CategoryParam;
import com.lpdev.salesmanagement.services.CategoryService;

@RestController
@RequestMapping(value = "/sales/categories")
public class CategoriesController {

	@Autowired
	CategoryService categoriesService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> add(CategoryParam categoryParam) {
		Category category = new Category();
		category.setName("Đồ Áo");
		categoriesService.persist(category);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
