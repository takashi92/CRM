package com.lpdev.salesmanagement.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.BillDetail;
import com.lpdev.salesmanagement.entities.BillDetailId;
import com.lpdev.salesmanagement.repositories.BillDetailRepository;

@Service
public class BillDetailService {

	private static final Log log = LogFactory.getLog(BillDetailService.class);

	@Autowired
	private BillDetailRepository billDetailRepository;

	public void persist(BillDetail transientInstance) {
		log.debug("persisting BillDetails instance");
		try {
			billDetailRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(BillDetail persistentInstance) {
		log.debug("removing BillDetails instance");
		try {
			billDetailRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public BillDetail merge(BillDetail detachedInstance) {
		log.debug("merging BillDetails instance");
		try {
			BillDetail result = billDetailRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BillDetail findById(BillDetailId id) {
		log.debug("getting BillDetails instance with id: " + id);
		try {
			BillDetail instance = billDetailRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
