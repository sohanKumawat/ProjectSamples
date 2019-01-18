package com.mb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.demo.entity.common.scanner.ItemScannerEntity;

@Repository
public interface ScannerDataRepository extends JpaRepository<ItemScannerEntity, Long>{

}

