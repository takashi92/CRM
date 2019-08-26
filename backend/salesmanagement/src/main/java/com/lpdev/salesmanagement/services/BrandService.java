package com.lpdev.salesmanagement.services;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.Brand;
import com.lpdev.salesmanagement.repositories.BrandRepository;

@Service
public class BrandService {

	private static final Log log = LogFactory.getLog(CategoryService.class);

	@Autowired
	private BrandRepository brandRepository;

	public void persist(Brand transientInstance) {
		log.debug("persisting Brand instance");
		try {
			transientInstance.setCreated(new Date().getTime());
			brandRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Brand persistentInstance) {
		log.debug("removing Brand instance");
		try {
			brandRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Brand merge(Brand detachedInstance) {
		log.debug("merging Brand instance");
		try {
			Brand result = brandRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Brand findById(Integer id) {
		log.debug("getting Brand instance with id: " + id);
		try {
			Brand instance = brandRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Brand findByName(String name) {
		log.debug("getting Brand instance with name: " + name);
		try {
			Brand instance = brandRepository.findByName(name);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
