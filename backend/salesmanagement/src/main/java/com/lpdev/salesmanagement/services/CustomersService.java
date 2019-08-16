package com.lpdev.salesmanagement.services;
// Generated Aug 7, 2019 9:03:04 PM by Hibernate Tools 4.3.5.Final

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpdev.salesmanagement.entities.Customers;
import com.lpdev.salesmanagement.repositories.CustomersRepository;

/**
 * Home object for domain model class Customers.
 * 
 * @see com.lpdev.salesmanagement.entities.Customers
 * @author Hibernate Tools
 */
@Service
public class CustomersService {

	private static final Log log = LogFactory.getLog(CustomersService.class);

	@Autowired
	private CustomersRepository customersRepository;

	public void persist(Customers transientInstance) {
		log.debug("persisting Customers instance");
		try {
			customersRepository.save(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Customers persistentInstance) {
		log.debug("removing Customers instance");
		try {
			customersRepository.delete(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Customers merge(Customers detachedInstance) {
		log.debug("merging Customers instance");
		try {
			Customers result = customersRepository.saveAndFlush(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Customers findById(Integer id) {
		log.debug("getting Customers instance with id: " + id);
		try {
			Customers instance = customersRepository.getOne(id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
