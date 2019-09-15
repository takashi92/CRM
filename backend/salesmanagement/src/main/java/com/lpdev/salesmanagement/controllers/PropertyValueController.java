package com.lpdev.salesmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.commons.CommonResult;
import com.lpdev.salesmanagement.params.PropertyValueParam;
import com.lpdev.salesmanagement.services.PropertyValueService;

@RestController
@RequestMapping(value = "/property-value")
public class PropertyValueController {

	@Autowired
	PropertyValueService propertyValueService = new PropertyValueService();

	@RequestMapping(method = RequestMethod.POST)
	public CommonResult saveOrUpdate(@RequestBody PropertyValueParam propertyValueParam) {
		return propertyValueService.saveOrUpdate(propertyValueParam);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public CommonResult delete(@PathVariable("id") Integer id) {
		return propertyValueService.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public CommonResult findAll() {
		return propertyValueService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public CommonResult findById(@PathVariable("id") Integer id) {
		return propertyValueService.findById(id);
	}
}
