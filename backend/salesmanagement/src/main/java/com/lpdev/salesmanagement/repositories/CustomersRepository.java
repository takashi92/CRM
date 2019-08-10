package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
