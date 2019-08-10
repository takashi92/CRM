package com.lpdev.salesmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.entities.Products;
import com.lpdev.salesmanagement.services.ProductsService;

@RestController
@RequestMapping(value = "/salesmanagement/products")
public class ProductsController {

	@Autowired
	ProductsService productsService;

	@GetMapping
	public List<Products> getAll() {
		List<Products> products = productsService.findAll();
		if (products.isEmpty())
			return null;
		return products;
	}
}
