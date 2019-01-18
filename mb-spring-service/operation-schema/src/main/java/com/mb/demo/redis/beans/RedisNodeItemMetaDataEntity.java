package com.mb.demo.redis.beans;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mb.demo.constants.PickPackConstants;
import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.constants.PickPackConstants.StorageNode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash(value = "nodeProductMetadata", timeToLive = 36000) // this object automatic destroy after 10hours
@Data
@JsonInclude(Include.NON_DEFAULT)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RedisNodeItemMetaDataEntity implements Serializable {
	private static final long serialVersionUID = 4546116960861492322L;
	@Id
	private String id;
	@Indexed
	private long nodeId;
	@Indexed
	private long productId;
	@Indexed
	private long hubId;
	private StorageNode nodeType;
	@Indexed
	private String sheet;
	private String name;// SA
	private String title;// SA
	private String trackerNumber; // 4
	private String scannerCode; // 4
	private StorageNode nodeStorageType;
	@Indexed
	private OperationType nodeArea;
	private String description;// SA
	private List<RedisNodeItemMetaDataEntity> nodeItems;

	public static RedisNodeItemMetaDataEntity newInstance() {
		return new RedisNodeItemMetaDataEntity();
	}

	public void generateId() {
		this.id = PickPackConstants.REDIS_KEY_PREFIX + "#" + this.hubId + "#" + this.nodeId + "#" + this.sheet;
	}

}
