package com.mb.demo.redis.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mb.demo.constants.PickPackConstants.StorageNode;
import com.mb.demo.redis.beans.RedisNodeItemMetaDataEntity;
import com.mb.demo.redis.rowmapper.NodeStorageRowMapper;
import com.mb.demo.redis.service.RedisNodeitemMetaDataStoreService;

@processor
public class NodeItemMetdaDataProcessor {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	RedisNodeitemMetaDataStoreService redisNodeItemStoreService;

	public void creatNodeItemStorage() {
		String sql = "select * from `pickpackdb`.`node_storage_meta_data` where parent_type='NONE' and parent_id=-1";
		List<RedisNodeItemMetaDataEntity> node = jdbcTemplate.query(sql, new NodeStorageRowMapper(false));
		for (int i = 0; node != null && i < node.size(); i++) {
			getChildNode(node.get(i));
			redisNodeItemStoreService.saveNodeStorage(node.get(i));
		}

		System.out.println("Node storage list " + node.toString());

	}

	public void getChildNode(RedisNodeItemMetaDataEntity rootNode) {

		if (rootNode.getNodeStorageType().equals(StorageNode.PRODUCT)) {
			getNodeProductMappingData(rootNode);
		} else {
			String sql = "select * from `pickpackdb`.`node_storage_meta_data` where parent_id in ("
					+ rootNode.getNodeId() + ")";
			List<RedisNodeItemMetaDataEntity> node = jdbcTemplate.query(sql, new NodeStorageRowMapper(false));
			rootNode.setNodeItems(node);
			for (int j = 0; node != null && j < node.size(); j++) {
				getChildNode(node.get(j));
			}
		}
	}

	public void getNodeProductMappingData(RedisNodeItemMetaDataEntity rootNode) {
		String sql = "select ns.*,npm.product_id from `pickpackdb`.`node_storage_meta_data` as ns,pickpackdb.node_product_mapping as npm where npm.node_id ="
				+ rootNode.getNodeId() + " and ns.hub_id=npm.hub_id and ns.id=npm.node_id";
		List<RedisNodeItemMetaDataEntity> nodeItems = jdbcTemplate.query(sql, new NodeStorageRowMapper(true));
		rootNode.setNodeItems(nodeItems);
	}

	public String getPath(String path, String nextPath) {
		return path + " -> " + nextPath;
	}

}
