package com.lpdev.salesmanagement.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.Customer;
import com.lpdev.salesmanagement.repositories.CustomerRepository;

@Service
public class CustomerService {

	private static final Log log = LogFactory.getLog(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepository;

	public void persist(Customer transientInstance) {
		log.debug("persisting Customers instance");
		try {
			customerRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Customer persistentInstance) {
		log.debug("removing Customers instance");
		try {
			customerRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Customer merge(Customer detachedInstance) {
		log.debug("merging Customers instance");
		try {
			Customer result = customerRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Customer findById(Integer id) {
		log.debug("getting Customers instance with id: " + id);
		try {
			Customer instance = customerRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
