package com.lpdev.salesmanagement.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.BillDetails;
import com.lpdev.salesmanagement.entities.BillDetailsId;
import com.lpdev.salesmanagement.repositories.BillDetailsRepository;

@Service
public class BillDetailsService {

	private static final Log log = LogFactory.getLog(BillDetailsService.class);

	@Autowired
	private BillDetailsRepository billDetailsRepository;

	public void persist(BillDetails transientInstance) {
		log.debug("persisting BillDetails instance");
		try {
			billDetailsRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(BillDetails persistentInstance) {
		log.debug("removing BillDetails instance");
		try {
			billDetailsRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public BillDetails merge(BillDetails detachedInstance) {
		log.debug("merging BillDetails instance");
		try {
			BillDetails result = billDetailsRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BillDetails findById(BillDetailsId id) {
		log.debug("getting BillDetails instance with id: " + id);
		try {
			BillDetails instance = billDetailsRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
