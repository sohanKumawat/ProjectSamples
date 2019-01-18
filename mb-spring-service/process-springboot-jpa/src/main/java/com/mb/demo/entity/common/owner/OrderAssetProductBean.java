package com.mb.demo.entity.common.owner;

import java.io.Serializable;

import com.mb.demo.constants.PickPackConstants.ItemType;
import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.BaseOperationBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrderAssetProductBean extends BaseOperationBean implements Serializable {
	private static final long serialVersionUID = 4358370611893940251L;
	private long id;
	private String orderId;
	private String customerId;
	private String assetId;
	private ItemType assetType;// crate,bages
	private OperationType operationLevel;
	private int totalProductQuantity;
	private String status;// crate/bages status - open, inprogress, done
}
