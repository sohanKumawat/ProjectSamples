package com.mb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.demo.entity.common.node.NodeProductMappingEntity;

@Repository
public interface NodeProductMappingRespository extends JpaRepository<NodeProductMappingEntity, Long>{

	public NodeProductMappingEntity findByHubIdAndNodeIdAndProductId(long hubId, long nodeId,long productId);
	
	
}