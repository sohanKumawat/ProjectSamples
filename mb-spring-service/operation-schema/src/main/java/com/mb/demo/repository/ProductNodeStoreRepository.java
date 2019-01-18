package com.mb.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.node.ProductNodeStoreEntity;

@Repository
public interface ProductNodeStoreRepository extends JpaRepository<ProductNodeStoreEntity, Long> {

	public List<ProductNodeStoreEntity> findByProductIdAndHubIdAndTeamIdAndSheet(long productId, long hubId,
			long teamId, String sheet);

	public List<ProductNodeStoreEntity> findByProductIdAndHubIdAndTeamIdAndNodeIdAndSheet(long productId, long hubId,
			long teamId, long nodeId, String sheet);

	public List<ProductNodeStoreEntity> findByProductIdAndHubIdAndTeamIdAndSheetAndNodeArea(long productId, long hubId,
			long teamId, String sheet, OperationType nodeArea);

	public List<ProductNodeStoreEntity> findByNodeId(long nodeId);

	public List<ProductNodeStoreEntity> findByProductIdAndHubId(long productId, long hubId);

	public List<ProductNodeStoreEntity> findByProductIdAndHubIdAndNodeId(long productId, long hubId, long nodeId);

	public List<ProductNodeStoreEntity> findByNodeIdAndNodeArea(long nodeId, OperationType nodeArea);

	public List<ProductNodeStoreEntity> findByHubIdAndNodeIdAndNodeArea(long hubId, long nodeId,
			OperationType nodeArea);

	public List<ProductNodeStoreEntity> findByHubIdAndTeamIdAndSheetAndNodeArea(long hubId, long teamId, String sheet,
			OperationType nodeArea);

}
