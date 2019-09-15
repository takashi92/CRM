package com.lpdev.salesmanagement.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lpdev.salesmanagement.commons.CommonResult;
import com.lpdev.salesmanagement.entities.Property;
import com.lpdev.salesmanagement.repositories.PropertyRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class PropertyService {

	@Autowired
	private PropertyRepository propertyRepository;

	public CommonResult saveOrUpdate(Property property) {
		try {
			String code = property.getCode();
			Optional<Property> opProperty = propertyRepository.findById(code);
			if (opProperty.isPresent()) {
				property.setCreated(opProperty.get().getCreated());
				property.setUpdated(new Date().getTime());
				propertyRepository.saveAndFlush(property);
				return CommonResult.getResult(true, "updated Property successful", property);
			}

			property.setCreated(new Date().getTime());
			propertyRepository.save(property);
			return CommonResult.getResult(true, "created Property successful", property);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public CommonResult delete(String id) {
		try {
			propertyRepository.deleteById(id);
			return CommonResult.getResult(true, "deleted Property successful", null);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public CommonResult findById(String id) {
		try {
			Optional<Property> opProperty = propertyRepository.findById(id);
			if (opProperty.isPresent()) {
				return CommonResult.getResult(true, "get Property successful", opProperty.get());
			}

			return CommonResult.getResult(false, "Property CODE = " + id + " is not exist", null);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public CommonResult findAll() {
		try {
			return CommonResult.getResult(true, "get Propertys successful", propertyRepository.findAll());
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
