package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpdev.salesmanagement.entities.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

}
