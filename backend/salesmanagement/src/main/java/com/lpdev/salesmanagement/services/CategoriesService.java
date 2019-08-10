package com.lpdev.salesmanagement.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.Categories;
import com.lpdev.salesmanagement.repositories.CategoriesRepository;

@Service
public class CategoriesService {

	private static final Log log = LogFactory.getLog(CategoriesService.class);

	@Autowired
	private CategoriesRepository categoriesRepository;

	public void persist(Categories transientInstance) {
		log.debug("persisting Categories instance");
		try {
			categoriesRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Categories persistentInstance) {
		log.debug("removing Categories instance");
		try {
			categoriesRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Categories merge(Categories detachedInstance) {
		log.debug("merging Categories instance");
		try {
			Categories result = categoriesRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Categories findById(Integer id) {
		log.debug("getting Categories instance with id: " + id);
		try {
			Categories instance = categoriesRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
