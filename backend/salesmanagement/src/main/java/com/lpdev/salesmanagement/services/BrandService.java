package com.lpdev.salesmanagement.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lpdev.salesmanagement.commons.CommonResult;
import com.lpdev.salesmanagement.entities.Brand;
import com.lpdev.salesmanagement.repositories.BrandRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;

	public CommonResult saveOrUpdate(Brand brand) {
		try {
			Integer id = brand.getId();
			if (id == null) {
				brand.setCreated(new Date().getTime());
				brandRepository.save(brand);
				return CommonResult.getResult(true, "created Brand successful", brand);
			}

			Optional<Brand> opBrand = brandRepository.findById(id);
			if (opBrand.isPresent()) {
				brand.setCreated(opBrand.get().getCreated());
				brand.setUpdated(new Date().getTime());
				brandRepository.saveAndFlush(brand);
				return CommonResult.getResult(true, "updated Brand successful", brand);
			}

			return CommonResult.getResult(false, "Brand ID = " + id + " is not exist", null);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public CommonResult delete(Integer id) {
		try {
			brandRepository.deleteById(id);
			return CommonResult.getResult(true, "deleted Brand successful", null);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public CommonResult findById(Integer id) {
		try {
			Optional<Brand> opBrand = brandRepository.findById(id);
			if (opBrand.isPresent()) {
				return CommonResult.getResult(true, "get Brand successful", opBrand.get());
			}

			return CommonResult.getResult(false, "Brand ID = " + id + " is not exist", null);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public CommonResult findAll() {
		try {
			return CommonResult.getResult(true, "get Brands successful", brandRepository.findAll());
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
