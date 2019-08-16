package com.lpdev.salesmanagement.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.Supply;
import com.lpdev.salesmanagement.entities.SupplyId;
import com.lpdev.salesmanagement.repositories.SupplyRepository;

@Service
public class SupplyService {

	private static final Log log = LogFactory.getLog(SupplyService.class);

	@Autowired
	private SupplyRepository supplyRepository;

	public void persist(Supply transientInstance) {
		log.debug("persisting Supply instance");
		try {
			supplyRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Supply persistentInstance) {
		log.debug("removing Supply instance");
		try {
			supplyRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Supply merge(Supply detachedInstance) {
		log.debug("merging Supply instance");
		try {
			Supply result = supplyRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Supply findById(SupplyId id) {
		log.debug("getting Supply instance with id: " + id);
		try {
			Supply instance = supplyRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
