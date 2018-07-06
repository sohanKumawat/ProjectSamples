package com.mb.demo.entity.common.owner;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mb.demo.constants.PickPackConstants.ItemType;
import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.BaseOperationEntity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 * This class used at owner, packer and sequencer level. order specific and specific crate/bags contain how many items.
 * 
 * This entity not used for identified identity of item. mean it know how many elements in
 *  but it does have knowledge about the specific element.
 * 
 * 
 * */
@Data
@EqualsAndHashCode(callSuper = false)
@Table
@Entity(name = "order_asset_item_store")
@ApiModel(description = "Order asset item store request data pojo ")
public class OrderAssetItemStoreEntity extends BaseOperationEntity implements Serializable {

	private static final long serialVersionUID = 2815657549226520645L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long orderId;
	private long assetId;
	private ItemType assetType;// crate, bags
	private OperationType operationLevel;// owner, packer, sequencer
	private int itemQuantity;
	private ItemType itemType;// bags, products
}
