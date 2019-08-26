package com.lpdev.salesmanagement.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.Bill;
import com.lpdev.salesmanagement.repositories.BillRepository;

@Service
public class BillService {

	private static final Log log = LogFactory.getLog(BillService.class);

	@Autowired
	private BillRepository billRepository;

	public void persist(Bill transientInstance) {
		log.debug("persisting Bills instance");
		try {
			billRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Bill persistentInstance) {
		log.debug("removing Bills instance");
		try {
			billRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Bill merge(Bill detachedInstance) {
		log.debug("merging Bills instance");
		try {
			Bill result = billRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Bill findById(Integer id) {
		log.debug("getting Bills instance with id: " + id);
		try {
			Bill instance = billRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
