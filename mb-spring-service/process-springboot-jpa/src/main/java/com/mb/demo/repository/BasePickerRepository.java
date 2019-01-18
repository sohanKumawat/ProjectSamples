package com.mb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.demo.entity.common.asset.AssetItemStoreEntity;

@Repository
public interface BasePickerRepository extends JpaRepository<AssetItemStoreEntity, Long> {

}
