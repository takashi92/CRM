package com.lpdev.salesmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.entities.Categories;
import com.lpdev.salesmanagement.entities.Properties;
import com.lpdev.salesmanagement.services.CategoriesService;
import com.lpdev.salesmanagement.services.PropertiesService;

@RestController
@RequestMapping(value = "/sales/init")
public class MainController {

	@Autowired
	CategoriesService categoriesService;

	@Autowired
	PropertiesService propertiesService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> init() {

		Categories category = new Categories();
		category.setName("Đồ Áo");
		categoriesService.persist(category);

		Properties property = new Properties();
		property.setCategories(category);
		property.setCode("material");
		propertiesService.persist(property);

		property = new Properties();
		property.setCategories(category);
		property.setCode("description");
		propertiesService.persist(property);

		property = new Properties();
		property.setCategories(category);
		property.setCode("color");
		propertiesService.persist(property);

		property = new Properties();
		property.setCategories(category);
		property.setCode("size");
		propertiesService.persist(property);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
