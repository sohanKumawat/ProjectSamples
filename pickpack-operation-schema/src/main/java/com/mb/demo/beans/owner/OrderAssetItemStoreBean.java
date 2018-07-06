package com.mb.demo.beans.owner;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mb.demo.beans.BaseOperationBean;
import com.mb.demo.constants.PickPackConstants.ItemType;
import com.mb.demo.constants.PickPackConstants.OperationType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrderAssetItemStoreBean extends BaseOperationBean implements Serializable {

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
	// private String status;// crate/bags status - open, in progress, done

}
