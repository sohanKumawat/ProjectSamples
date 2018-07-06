package com.mb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.demo.entity.common.node.NodeStorageDataEntity;

@Repository
public interface NodeStorageDataRepository extends JpaRepository<NodeStorageDataEntity, Long>{

}

