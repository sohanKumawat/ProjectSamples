package com.mb.demo.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.redis.beans.RedisNodeItemMetaDataEntity;
import com.mb.demo.redis.repository.RedisNodeItemDataRepository;

@Component
public class RedisNodeitemMetaDataStoreService {

	@Autowired
	RedisNodeItemDataRepository nodeItemDataRepo;

	public RedisNodeItemMetaDataEntity saveNodeStorage(RedisNodeItemMetaDataEntity nodeEntity) {
		nodeEntity.generateId();
		return nodeItemDataRepo.save(nodeEntity);
	}

	public RedisNodeItemMetaDataEntity updateNodeStorage(RedisNodeItemMetaDataEntity nodeEntity) {
		return nodeItemDataRepo.save(nodeEntity);
	}

	public RedisNodeItemMetaDataEntity findById(String id) {
		return nodeItemDataRepo.findById(id).orElse(null);
	}

	public RedisNodeItemMetaDataEntity findByNodeIdAndHubId(long nodeId, long hubId) {
		return nodeItemDataRepo.findByNodeIdAndHubId(nodeId, hubId);
	}

	public RedisNodeItemMetaDataEntity findByNodeIdAndSheet(long nodeId, String sheet) {
		return nodeItemDataRepo.findByNodeIdAndSheet(nodeId, sheet);
	}

	public RedisNodeItemMetaDataEntity findByHubIdAndSheet(long hubId, String sheet) {
		return nodeItemDataRepo.findByHubIdAndSheet(hubId, sheet);
	}

	public RedisNodeItemMetaDataEntity findByNodeId(long nodeId) {
		return nodeItemDataRepo.findByNodeId(nodeId);
	}
	public List<RedisNodeItemMetaDataEntity> findByHubId(long hubId) {
		return nodeItemDataRepo.findByHubId(hubId);
	}

	public RedisNodeItemMetaDataEntity findByHubIdAndNodeArea(long nodeId, OperationType nodArea) {
		return nodeItemDataRepo.findByHubIdAndNodeArea(nodeId, nodArea);
	}

}
