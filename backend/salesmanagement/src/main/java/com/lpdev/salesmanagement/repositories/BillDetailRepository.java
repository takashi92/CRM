package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.BillDetail;
import com.lpdev.salesmanagement.entities.BillDetailId;

public interface BillDetailRepository extends JpaRepository<BillDetail, BillDetailId> {

}
