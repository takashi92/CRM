package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.Bills;

public interface BillsRepository extends JpaRepository<Bills, Integer> {

}
