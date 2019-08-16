package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpdev.salesmanagement.entities.Storage;
import com.lpdev.salesmanagement.entities.StorageId;

public interface StorageRepository extends JpaRepository<Storage, StorageId> {

}
