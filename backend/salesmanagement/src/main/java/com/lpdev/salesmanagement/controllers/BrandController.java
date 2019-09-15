package com.lpdev.salesmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.commons.CommonResult;
import com.lpdev.salesmanagement.entities.Brand;
import com.lpdev.salesmanagement.services.BrandService;

@RestController
@RequestMapping(value = "/brand")
public class BrandController {

	@Autowired
	BrandService brandService = new BrandService();

	@RequestMapping(method = RequestMethod.POST)
	public CommonResult saveOrUpdate(@RequestBody Brand brand) {
		return brandService.saveOrUpdate(brand);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public CommonResult delete(@PathVariable("id") Integer id) {
		return brandService.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public CommonResult findAll() {
		return brandService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public CommonResult findById(@PathVariable("id") Integer id) {
		return brandService.findById(id);
	}
}
