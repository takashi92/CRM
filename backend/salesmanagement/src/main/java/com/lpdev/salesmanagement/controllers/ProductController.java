package com.lpdev.salesmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.commons.CommonResult;
import com.lpdev.salesmanagement.models.params.ProductParam;
import com.lpdev.salesmanagement.services.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(method = RequestMethod.POST)
	public CommonResult save(@RequestBody ProductParam productParam) {
		return productService.save(productParam);
	}

	@RequestMapping(method = RequestMethod.GET)
	public CommonResult findAll() {
		return productService.findAll();
	}
}
