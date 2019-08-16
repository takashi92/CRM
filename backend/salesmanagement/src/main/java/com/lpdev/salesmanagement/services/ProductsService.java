package com.lpdev.salesmanagement.services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.Products;
import com.lpdev.salesmanagement.repositories.ProductsRepository;

@Service
public class ProductsService {

	private static final Log log = LogFactory.getLog(ProductsService.class);

	@Autowired
	private ProductsRepository productsRepository;

	public void persist(Products transientInstance) {
		log.debug("persisting Products instance");
		try {
			productsRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Products persistentInstance) {
		log.debug("removing Products instance");
		try {
			productsRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Products merge(Products detachedInstance) {
		log.debug("merging Products instance");
		try {
			Products result = productsRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Products findById(Integer id) {
		log.debug("getting Products instance with id: " + id);
		try {
			Products instance = productsRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Products> findAll() {
		try {
			List<Products> products = productsRepository.findAll();
			log.debug("get successful");
			return products;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
