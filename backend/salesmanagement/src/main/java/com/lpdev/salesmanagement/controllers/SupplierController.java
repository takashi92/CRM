package com.lpdev.salesmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.commons.CommonResult;
import com.lpdev.salesmanagement.entities.Supplier;
import com.lpdev.salesmanagement.services.SupplierService;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {

	@Autowired
	SupplierService supplierService = new SupplierService();

	@RequestMapping(method = RequestMethod.POST)
	public CommonResult saveOrUpdate(@RequestBody Supplier supplier) {
		return supplierService.saveOrUpdate(supplier);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public CommonResult delete(@PathVariable("id") Integer id) {
		return supplierService.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public CommonResult findAll() {
		return supplierService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public CommonResult findById(@PathVariable("id") Integer id) {
		return supplierService.findById(id);
	}
}
