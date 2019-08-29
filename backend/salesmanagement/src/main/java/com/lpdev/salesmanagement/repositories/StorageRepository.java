package com.lpdev.salesmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpdev.salesmanagement.entities.Storage;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Integer> {

}
