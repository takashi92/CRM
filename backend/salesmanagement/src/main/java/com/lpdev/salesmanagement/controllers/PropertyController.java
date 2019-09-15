package com.lpdev.salesmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.commons.CommonResult;
import com.lpdev.salesmanagement.entities.Property;
import com.lpdev.salesmanagement.services.PropertyService;

@RestController
@RequestMapping(value = "/property")
public class PropertyController {

	@Autowired
	PropertyService propertyService = new PropertyService();

	@RequestMapping(method = RequestMethod.POST)
	public CommonResult saveOrUpdate(@RequestBody Property property) {
		return propertyService.saveOrUpdate(property);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public CommonResult delete(@PathVariable("id") String id) {
		return propertyService.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public CommonResult findAll() {
		return propertyService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public CommonResult findById(@PathVariable("id") String id) {
		return propertyService.findById(id);
	}
}
