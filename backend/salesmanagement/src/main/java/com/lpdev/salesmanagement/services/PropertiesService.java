package com.lpdev.salesmanagement.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.Properties;
import com.lpdev.salesmanagement.repositories.PropertiesRepository;

@Service
public class PropertiesService {

	private static final Log log = LogFactory.getLog(PropertiesService.class);

	@Autowired
	private PropertiesRepository propertiesRepository;

	public void persist(Properties transientInstance) {
		log.debug("persisting Properties instance");
		try {
			propertiesRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Properties persistentInstance) {
		log.debug("removing Properties instance");
		try {
			propertiesRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Properties merge(Properties detachedInstance) {
		log.debug("merging Properties instance");
		try {
			Properties result = propertiesRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Properties findById(Integer id) {
		log.debug("getting Properties instance with id: " + id);
		try {
			Properties instance = propertiesRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
