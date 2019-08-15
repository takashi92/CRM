package com.lpdev.salesmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.entities.Categories;
import com.lpdev.salesmanagement.models.params.CategoryParam;
import com.lpdev.salesmanagement.services.CategoriesService;

@RestController
@RequestMapping(value = "/sales/categories")
public class CategoriesController {

	@Autowired
	CategoriesService categoriesService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> add(CategoryParam categoryParam) {
		Categories category = new Categories();
		category.setName(categoryParam.getName());
		categoriesService.persist(category);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
