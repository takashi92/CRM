package com.lpdev.salesmanagement.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.Bills;
import com.lpdev.salesmanagement.repositories.BillsRepository;

@Service
public class BillsService {

	private static final Log log = LogFactory.getLog(BillsService.class);

	@Autowired
	private BillsRepository billsRepository;

	public void persist(Bills transientInstance) {
		log.debug("persisting Bills instance");
		try {
			billsRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Bills persistentInstance) {
		log.debug("removing Bills instance");
		try {
			billsRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Bills merge(Bills detachedInstance) {
		log.debug("merging Bills instance");
		try {
			Bills result = billsRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Bills findById(Integer id) {
		log.debug("getting Bills instance with id: " + id);
		try {
			Bills instance = billsRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
