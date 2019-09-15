package com.lpdev.salesmanagement.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lpdev.salesmanagement.commons.CommonResult;
import com.lpdev.salesmanagement.entities.Property;
import com.lpdev.salesmanagement.entities.PropertyValue;
import com.lpdev.salesmanagement.params.PropertyValueParam;
import com.lpdev.salesmanagement.repositories.PropertyRepository;
import com.lpdev.salesmanagement.repositories.PropertyValueRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class PropertyValueService {

	@Autowired
	private PropertyValueRepository propertyValueRepository;

	@Autowired
	private PropertyRepository propertyRepository;

	public CommonResult saveOrUpdate(PropertyValueParam propertyValueParam) {
		try {
			String propertyCode = propertyValueParam.getPropertyCode();
			Optional<Property> opProperty = propertyRepository.findById(propertyCode);
			if (!opProperty.isPresent()) {
				return CommonResult.getResult(false, "Property CODE = " + propertyCode + " is not exist", null);
			}

			Integer id = propertyValueParam.getId();
			if (id == null) {
				PropertyValue propertyValue = new PropertyValue();
				propertyValue.setProperty(opProperty.get());
				propertyValue.setName(propertyValueParam.getName());
				propertyValue.setNote(propertyValueParam.getNote());
				propertyValue.setCreated(new Date().getTime());
				propertyValueRepository.save(propertyValue);
				return CommonResult.getResult(true, "created PropertyValue successful", propertyValue);
			}

			Optional<PropertyValue> opPropertyValue = propertyValueRepository.findById(id);
			if (opPropertyValue.isPresent()) {
				PropertyValue propertyValue = opPropertyValue.get();
				propertyValue.setName(propertyValueParam.getName());
				propertyValue.setNote(propertyValueParam.getNote());
				propertyValue.setUpdated(new Date().getTime());
				propertyValueRepository.saveAndFlush(propertyValue);
				return CommonResult.getResult(true, "updated PropertyValue successful", propertyValue);
			}

			return CommonResult.getResult(false, "PropertyValue ID = " + id + " is not exist", null);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public CommonResult delete(Integer id) {
		try {
			propertyValueRepository.deleteById(id);
			return CommonResult.getResult(true, "deleted PropertyValue successful", null);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public CommonResult findById(Integer id) {
		try {
			Optional<PropertyValue> opPropertyValue = propertyValueRepository.findById(id);
			if (opPropertyValue.isPresent()) {
				return CommonResult.getResult(true, "get PropertyValue successful", opPropertyValue.get());
			}

			return CommonResult.getResult(false, "PropertyValue ID = " + id + " is not exist", null);

		} catch (RuntimeException re) {
			throw re;
		}
	}

	public CommonResult findAll() {
		try {
			return CommonResult.getResult(true, "get PropertyValues successful", propertyValueRepository.findAll());
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
