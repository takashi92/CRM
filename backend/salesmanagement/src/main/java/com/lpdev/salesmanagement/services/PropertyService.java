package com.lpdev.salesmanagement.services;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.Property;
import com.lpdev.salesmanagement.repositories.PropertyRepository;

@Service
public class PropertyService {

	private static final Log log = LogFactory.getLog(PropertyService.class);

	@Autowired
	private PropertyRepository propertyRepository;

	public void persist(Property transientInstance) {
		log.debug("persisting Properties instance");
		try {
			transientInstance.setCreated(new Date().getTime());
			propertyRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Property persistentInstance) {
		log.debug("removing Properties instance");
		try {
			propertyRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Property merge(Property detachedInstance) {
		log.debug("merging Properties instance");
		try {
			Property result = propertyRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Property findById(Integer id) {
		log.debug("getting Properties instance with id: " + id);
		try {
			Property instance = propertyRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
