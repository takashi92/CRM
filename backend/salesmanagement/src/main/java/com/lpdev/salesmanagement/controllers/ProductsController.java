package com.lpdev.salesmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.entities.Product;
import com.lpdev.salesmanagement.services.ProductService;

@RestController
@RequestMapping(value = "/salesmanagement/products")
public class ProductsController {

	@Autowired
	ProductService productService;

	@GetMapping
	public List<Product> getAll() {
		List<Product> products = productService.findAll();
		if (products.isEmpty())
			return null;
		return products;
	}
}
