package com.mb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.node.ProductNodeStoreEntity;
import com.mb.demo.repository.ProductNodeStoreRepository;

@Service
public class ProductNodeStoreService implements BasePickerServcie<ProductNodeStoreEntity> {

	@Autowired
	ProductNodeStoreRepository repository;

	@Override
	public void add(ProductNodeStoreEntity entity) {
		repository.save(entity);

	}

	@Override
	public ProductNodeStoreEntity getById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<ProductNodeStoreEntity> getAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

	@Override
	public void update(ProductNodeStoreEntity entity) {
		repository.save(entity);

	}

	public List<ProductNodeStoreEntity> findByProductIdAndHubIdAndTeamIdAndSheet(long productId, long hubId,
			long teamId, String sheet) {
		return repository.findByProductIdAndHubIdAndTeamIdAndSheet(productId, hubId, teamId, sheet);
	}
	
	public List<ProductNodeStoreEntity> findByProductIdAndHubIdAndTeamIdAndSheetAndNodeArea(long productId, long hubId,
			long teamId, String sheet,OperationType nodeArea) {
		return repository.findByProductIdAndHubIdAndTeamIdAndSheetAndNodeArea(productId, hubId, teamId, sheet,nodeArea);
	}
	public List<ProductNodeStoreEntity> findByProductIdAndHubIdAndTeamIdAndNodeIdAndSheet(long productId, long hubId,
			long teamId,long nodeId, String sheet) {
		return repository.findByProductIdAndHubIdAndTeamIdAndSheet(productId, hubId, teamId, sheet);
	}

	public List<ProductNodeStoreEntity> findByNodeId(long nodeId) {
		return repository.findByNodeId(nodeId);
	}

	public List<ProductNodeStoreEntity> findByProductIdAndHubId(long productId, long hubId) {
		return repository.findByProductIdAndHubId(productId, hubId);
	}

	public List<ProductNodeStoreEntity> findByProductIdAndHubIdAndNodeId(long productId, long hubId, long nodeId) {
		return repository.findByProductIdAndHubIdAndNodeId(productId, hubId, nodeId);
	}

	public List<ProductNodeStoreEntity> findByNodeIdAndNodeArea(long nodeId, OperationType nodeArea) {
		return repository.findByNodeIdAndNodeArea(nodeId, nodeArea);
	}

}
