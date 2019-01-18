package com.mb.demo.entity.common.owner;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.mb.demo.constants.PickPackConstants.ItemType;
import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.BaseOperationBean;

import lombok.Data;
import lombok.EqualsAndHashCode;
/*
 * This class used at owner level and packer level. order specific and specific crate/bages contain how many products.
 * 
 * */
@Data
@EqualsAndHashCode(callSuper = false)
@Table
@Entity(name="order_asset_product_store")
public class OrderAssetProductStoreEntity extends BaseOperationBean implements Serializable {

	private static final long serialVersionUID = 2815657549226520645L;
	private long id;
	private String orderId;
	private String customerId;
	private String assetId;
	private ItemType assetType;//crate,bages
	private OperationType operationLevel;//owner
	private int totalProductQuantity;
	private String status;// crate/bages status - open, inprogress, done

}
