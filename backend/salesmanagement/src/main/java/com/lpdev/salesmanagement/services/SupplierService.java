package com.lpdev.salesmanagement.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lpdev.salesmanagement.commons.CommonResult;
import com.lpdev.salesmanagement.entities.Supplier;
import com.lpdev.salesmanagement.repositories.SupplierRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	public CommonResult saveOrUpdate(Supplier supplier) {
		try {
			Integer id = supplier.getId();
			if (id == null) {
				supplier.setCreated(new Date().getTime());
				supplierRepository.save(supplier);
				return CommonResult.getResult(true, "created Supplier successful", supplier);
			}

			Optional<Supplier> opSupplier = supplierRepository.findById(id);
			if (opSupplier.isPresent()) {
				supplier.setCreated(opSupplier.get().getCreated());
				supplier.setUpdated(new Date().getTime());
				supplierRepository.saveAndFlush(supplier);
				return CommonResult.getResult(true, "updated Supplier successful", supplier);
			}

			return CommonResult.getResult(false, "Supplier ID = " + id + " is not exist", null);

		} catch (RuntimeException re) {
			throw re;
		}
	}

	public CommonResult delete(Integer id) {
		try {
			supplierRepository.deleteById(id);
			return CommonResult.getResult(true, "deleted Supplier successful", null);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public CommonResult findById(Integer id) {
		try {
			Optional<Supplier> opSupplier = supplierRepository.findById(id);
			if (opSupplier.isPresent()) {
				return CommonResult.getResult(true, "get Supplier successful", opSupplier.get());
			}

			return CommonResult.getResult(false, "Supplier ID = " + id + " is not exist", null);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public CommonResult findAll() {
		try {
			return CommonResult.getResult(true, "get Suppliers successful", supplierRepository.findAll());
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
