package com.mb.demo.redis.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.constants.PickPackConstants.StorageNode;
import com.mb.demo.redis.beans.RedisNodeItemMetaDataEntity;

public class NodeStorageRowMapper implements RowMapper<RedisNodeItemMetaDataEntity> {

	private boolean isProductContain = false;

	public NodeStorageRowMapper(boolean isProductContain) {
		this.isProductContain = isProductContain;
	}

	@Override
	public RedisNodeItemMetaDataEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		RedisNodeItemMetaDataEntity node = RedisNodeItemMetaDataEntity.newInstance();
		node.setNodeId(rs.getLong("id"));
		node.setHubId(rs.getLong("hub_id"));
		node.setName(rs.getString("name"));
		node.setTitle(rs.getString("title"));
		node.setScannerCode(rs.getString("scanner_code"));
		addProductMapData(node, rs);
		node.setSheet(rs.getString("sheet"));
		node.setTrackerNumber(rs.getString("tracker_number"));
		node.setNodeArea(OperationType.valueOf(rs.getString("node_area")));
		node.setNodeStorageType(StorageNode.valueOf(rs.getString("storage_item_type")));
		return node;
	}

	public void addProductMapData(RedisNodeItemMetaDataEntity node, ResultSet rs) {
		if (this.isProductContain) {
			try {
				node.setProductId(rs.getLong("product_id"));
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
