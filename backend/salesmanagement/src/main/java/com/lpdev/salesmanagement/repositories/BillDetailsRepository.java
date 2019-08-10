package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.BillDetails;
import com.lpdev.salesmanagement.entities.BillDetailsId;

public interface BillDetailsRepository extends JpaRepository<BillDetails, BillDetailsId> {

}
