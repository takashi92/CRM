package com.lpdev.salesmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.entities.Category;
import com.lpdev.salesmanagement.services.CategoryService;
import com.lpdev.salesmanagement.services.PropertyService;

@RestController
@RequestMapping(value = "/sales/init")
public class MainController {

	@Autowired
	CategoryService categoriesService;

	@Autowired
	PropertyService propertiesService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> init() {

		Category category = new Category();
		category.setName("Đồ Áo");
		categoriesService.persist(category);

//		Property property = new Property();
//		property.setCode("material");
//		propertiesService.persist(property);
//
//		property = new Property();
//		property.setCode("description");
//		propertiesService.persist(property);
//
//		property = new Property();
//		property.setCode("color");
//		propertiesService.persist(property);
//
//		property = new Property();
//		property.setCode("size");
//		propertiesService.persist(property);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
