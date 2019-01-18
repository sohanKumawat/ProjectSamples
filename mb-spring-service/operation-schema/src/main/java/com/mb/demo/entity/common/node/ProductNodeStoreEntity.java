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
import com.mb.demo.entity.common.BaseEntity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "node_product_store")
@ApiModel(description = "Product Node store request data pojo ")
public class ProductNodeStoreEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1805039523544179392L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long nodeId;
	private String nodeTracker;
	private String nodeScannerCode;
	private long productId;
	private long hubId;
	private long teamId;
	@Enumerated(EnumType.STRING)
	private OperationType nodeArea;
	private String sheet;
	private int totalQuantity;//
	private int availableQuantity;//
	private int inUseQuantity;

	public static ProductNodeStoreEntity newInstance() {
		return new ProductNodeStoreEntity();
	}
}
