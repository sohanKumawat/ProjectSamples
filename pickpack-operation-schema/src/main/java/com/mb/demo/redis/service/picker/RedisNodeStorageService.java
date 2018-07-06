package com.mb.demo.redis.service.picker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.constants.PickPackConstants.StorageNode;
import com.mb.demo.redis.beans.RedisNodeItemMetaDataEntity;
import com.mb.demo.redis.service.RedisNodeitemMetaDataStoreService;

@Service
public class RedisNodeStorageService {
	@Autowired
	RedisNodeitemMetaDataStoreService redisNodeItemDataService;

	public RedisNodeItemMetaDataEntity findNodeByNodeId(long nodeId) {
		return redisNodeItemDataService.findByNodeId(nodeId);
	}
	
	public List<RedisNodeItemMetaDataEntity> findProductNodeByNodeId(long nodeId) {
		return findProductNodeList(redisNodeItemDataService.findByNodeId(nodeId));
	}
	public List<RedisNodeItemMetaDataEntity> findProductNodeByKey(String id) {
		return findProductNodeList(redisNodeItemDataService.findById(id));
	}

	public List<RedisNodeItemMetaDataEntity> findProductNodeList(RedisNodeItemMetaDataEntity node) {
		List<RedisNodeItemMetaDataEntity> productNode = new ArrayList<>();
		if (isNodeContainProduct(node)) {
			productNode.addAll(node.getNodeItems());
		} else {
			for (int i = 0; null != node.getNodeItems() && i < node.getNodeItems().size(); i++) {
				if (isNodeContainProduct(node.getNodeItems().get(i))) {
					productNode.addAll(node.getNodeItems().get(i).getNodeItems());
				} else {
					RedisNodeItemMetaDataEntity nextNode = node.getNodeItems().get(i);
					if (isNodeContainProduct(nextNode.getNodeItems().get(0))) {
						productNode.addAll(node.getNodeItems().get(i).getNodeItems());
					}
				}
			}
		}
		return productNode;
	}

	public boolean isNodeContainProduct(RedisNodeItemMetaDataEntity node) {
		return StorageNode.PRODUCT.name().equalsIgnoreCase(node.getNodeStorageType().name()) ? true : false;
	}
}
