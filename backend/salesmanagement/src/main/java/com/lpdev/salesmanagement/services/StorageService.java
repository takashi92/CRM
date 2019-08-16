package com.lpdev.salesmanagement.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.Storage;
import com.lpdev.salesmanagement.entities.StorageId;
import com.lpdev.salesmanagement.repositories.StorageRepository;

@Service
public class StorageService {

	private static final Log log = LogFactory.getLog(StorageService.class);

	@Autowired
	private StorageRepository storageRepository;

	public void persist(Storage transientInstance) {
		log.debug("persisting Storage instance");
		try {
			storageRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Storage persistentInstance) {
		log.debug("removing Storage instance");
		try {
			storageRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Storage merge(Storage detachedInstance) {
		log.debug("merging Storage instance");
		try {
			Storage result = storageRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Storage findById(StorageId id) {
		log.debug("getting Storage instance with id: " + id);
		try {
			Storage instance = storageRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
