package com.lpdev.salesmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lpdev.salesmanagement.commons.CommonResult;
import com.lpdev.salesmanagement.params.SupplyParam;
import com.lpdev.salesmanagement.services.SupplyService;

@RestController
@RequestMapping(value = "/suppy")
public class SupplyController {

	@Autowired
	private SupplyService supplyService;

	@RequestMapping(method = RequestMethod.POST)
	public CommonResult save(@RequestBody SupplyParam supplyParam) {
		return supplyService.save(supplyParam);
	}
}
