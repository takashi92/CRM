package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.Supply;
import com.lpdev.salesmanagement.entities.SupplyId;

public interface SupplyRepository extends JpaRepository<Supply, SupplyId> {

}
