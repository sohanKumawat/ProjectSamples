package com.mb.demo.redis.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.redis.beans.RedisNodeItemMetaDataEntity;

@Repository
public interface RedisNodeItemDataRepository extends CrudRepository<RedisNodeItemMetaDataEntity, String> {

	public RedisNodeItemMetaDataEntity findByNodeIdAndHubId(long nodeId, long hubId);

	public RedisNodeItemMetaDataEntity findByNodeIdAndSheet(long nodeId, String sheet);

	public RedisNodeItemMetaDataEntity findByHubIdAndSheet(long hubId, String sheet);

	public RedisNodeItemMetaDataEntity findByNodeId(long nodeId);

	public List<RedisNodeItemMetaDataEntity> findByHubId(long hubId);

	public List<RedisNodeItemMetaDataEntity> findBySheet(String sheet);

	public RedisNodeItemMetaDataEntity findByHubIdAndNodeArea(long hubId, OperationType nodArea);

	public RedisNodeItemMetaDataEntity findByHubIdAndNodeIdAndNodeArea(long hubId, long nodeId, OperationType nodArea);
}
