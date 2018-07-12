package com.mb.demo.entity.common.node;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.constants.PickPackConstants.StorageNode;
import com.mb.demo.entity.common.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="node_storage_meta_data")
public class NodeStorageDataEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1947402517043685200L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long hubId;
	private String sheet;
	@Enumerated(EnumType.STRING)
	private StorageNode type;
	private String name;
	private String title;
	private String parentId;
	@Enumerated(EnumType.STRING)
	private StorageNode parentType;
	private String trackerNumber;
	private String scannerCode;
	@Enumerated(EnumType.STRING)
	private OperationType nodeArea;
	private String description;
	@Enumerated(EnumType.STRING)
	private StorageNode storageItemType;// right now is not required

}
