package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpdev.salesmanagement.entities.BillDetail;
import com.lpdev.salesmanagement.entities.BillDetailId;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, BillDetailId> {

}
