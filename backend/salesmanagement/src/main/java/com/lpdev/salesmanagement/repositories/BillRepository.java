package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {

}
