package com.lpdev.salesmanagement.services;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.Category;
import com.lpdev.salesmanagement.repositories.CategoryRepository;

@Service
public class CategoryService {

	private static final Log log = LogFactory.getLog(CategoryService.class);

	@Autowired
	private CategoryRepository categoryRepository;

	public void persist(Category transientInstance) {
		log.debug("persisting Categories instance");
		try {
			transientInstance.setCreated(new Date().getTime());
			categoryRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Category persistentInstance) {
		log.debug("removing Categories instance");
		try {
			categoryRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Category merge(Category detachedInstance) {
		log.debug("merging Categories instance");
		try {
			Category result = categoryRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Category findById(Integer id) {
		log.debug("getting Categories instance with id: " + id);
		try {
			Category instance = categoryRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
