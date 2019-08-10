package com.lpdev.salesmanagement.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.Supplier;
import com.lpdev.salesmanagement.repositories.SupplierRepository;

@Service
public class SupplierService {

	private static final Log log = LogFactory.getLog(SupplierService.class);

	@Autowired
	private SupplierRepository supplierRepository;

	public void persist(Supplier transientInstance) {
		log.debug("persisting Supplier instance");
		try {
			supplierRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Supplier persistentInstance) {
		log.debug("removing Supplier instance");
		try {
			supplierRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Supplier merge(Supplier detachedInstance) {
		log.debug("merging Supplier instance");
		try {
			Supplier result = supplierRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Supplier findById(Integer id) {
		log.debug("getting Supplier instance with id: " + id);
		try {
			Supplier instance = supplierRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
