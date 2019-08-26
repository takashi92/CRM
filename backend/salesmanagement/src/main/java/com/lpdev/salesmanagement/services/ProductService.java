package com.lpdev.salesmanagement.services;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.Product;
import com.lpdev.salesmanagement.repositories.ProductRepository;

@Service
public class ProductService {

	private static final Log log = LogFactory.getLog(ProductService.class);

	@Autowired
	private ProductRepository productRepository;

	public void persist(Product transientInstance) {
		log.debug("persisting Products instance");
		try {
			transientInstance.setCreated(new Date().getTime());
			productRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Product persistentInstance) {
		log.debug("removing Products instance");
		try {
			productRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Product merge(Product detachedInstance) {
		log.debug("merging Products instance");
		try {
			Product result = productRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Product findById(Integer id) {
		log.debug("getting Products instance with id: " + id);
		try {
			Product instance = productRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Product> findAll() {
		try {
			List<Product> products = productRepository.findAll();
			log.debug("get successful");
			return products;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
