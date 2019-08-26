package com.lpdev.salesmanagement.services;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.ProductDetail;
import com.lpdev.salesmanagement.entities.ProductDetailId;
import com.lpdev.salesmanagement.repositories.ProductDetailRepository;

@Service
public class ProductDetailService {

	private static final Log log = LogFactory.getLog(ProductService.class);

	@Autowired
	private ProductDetailRepository productDetailRepository;

	public void persist(ProductDetail transientInstance) {
		log.debug("persisting ProductDetail instance");
		try {
			transientInstance.setCreated(new Date().getTime());
			productDetailRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ProductDetail persistentInstance) {
		log.debug("removing ProductDetail instance");
		try {
			productDetailRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProductDetail merge(ProductDetail detachedInstance) {
		log.debug("merging ProductDetail instance");
		try {
			ProductDetail result = productDetailRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProductDetail findById(ProductDetailId id) {
		log.debug("getting ProductDetail instance with id: " + id);
		try {
			ProductDetail instance = productDetailRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
