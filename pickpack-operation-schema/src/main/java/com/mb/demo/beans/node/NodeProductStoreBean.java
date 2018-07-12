package com.mb.demo.beans.node;

import java.io.Serializable;

import com.mb.demo.constants.PickPackConstants.OperationType;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class NodeProductStoreBean implements Serializable {
	private static final long serialVersionUID = 8472887195002194138L;

	private long productId;
	private long teamId;
	private long hubId;
	private String nodeScannerCode;
	private int productQuantity;
	private OperationType pickerType=OperationType.SAPICKER;
	private String sheet;

}
