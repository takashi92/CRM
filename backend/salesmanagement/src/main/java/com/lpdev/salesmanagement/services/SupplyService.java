package com.lpdev.salesmanagement.services;

import java.util.Date;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties.Storage;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.commons.CommonResult;
import com.lpdev.salesmanagement.entities.Product;
import com.lpdev.salesmanagement.entities.Supplier;
import com.lpdev.salesmanagement.entities.Supply;
import com.lpdev.salesmanagement.entities.SupplyId;
import com.lpdev.salesmanagement.params.SupplyParam;
import com.lpdev.salesmanagement.repositories.ProductRepository;
import com.lpdev.salesmanagement.repositories.SupplierRepository;
import com.lpdev.salesmanagement.repositories.SupplyRepository;

@Service
public class SupplyService {

	private static final Log log = LogFactory.getLog(SupplyService.class);

	@Autowired
	private SupplyRepository supplyRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SupplierRepository supplierRepository;


	public CommonResult save(SupplyParam supplyParam) {
		log.debug("saving Supply instance");
		CommonResult commonResult = new CommonResult();
		try {
			Optional<Product> product = productRepository.findById(supplyParam.getProductId());
			if (!product.isPresent()) {
				commonResult.setSuccess(false);
				commonResult.setMessage("product ID ko ton tai");
				return commonResult;
			}

			Optional<Supplier> supplier = supplierRepository.findById(supplyParam.getSupplierId());
			if (!supplier.isPresent()) {
				commonResult.setSuccess(false);
				commonResult.setMessage("supplier ID ko ton tai");
				return commonResult;
			}

			Supply supply = new Supply();
			SupplyId supplyId = new SupplyId();
			supplyId.setProductId(supplyParam.getProductId());
			supplyId.setSupplierId(supplyParam.getSupplierId());
			supply.setId(supplyId);
			supply.setPrice(supplyParam.getPrice());
			supply.setQuantity(supply.getQuantity());
			supply.setCreated(new Date().getTime());
			supplyRepository.save(supply);
			Optional<Storage> storageOP = storageRepository.findById(supplyParam.getProductId());
			Storage storage = storageOP.get();
			storage.setProductId(supplyParam.getProductId());
			storage.setPrice(supply.getPrice());
			storage.setQuantity(storage.getQuantity() + supply.getQuantity());
			storageRepository.saveAndFlush(storage);
			log.debug("save successful");
			commonResult.setSuccess(true);
			commonResult.setMessage("save successful");
			return commonResult;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Supply persistentInstance) {
		log.debug("removing Supply instance");
		try {
			supplyRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Supply merge(Supply detachedInstance) {
		log.debug("merging Supply instance");
		try {
			Supply result = supplyRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Supply findById(SupplyId id) {
		log.debug("getting Supply instance with id: " + id);
		try {
			Supply instance = supplyRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
