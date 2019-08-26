package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
