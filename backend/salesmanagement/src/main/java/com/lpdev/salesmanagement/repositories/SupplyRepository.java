package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpdev.salesmanagement.entities.Supply;
import com.lpdev.salesmanagement.entities.SupplyId;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, SupplyId> {

}
