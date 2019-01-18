package com.mb.demo.beans;

import com.mb.demo.constants.PickPackConstants.OperationType;

import lombok.Data;

@Data
public class SelfDataBean {

	private String shelfNumber;// SA
	private String cellPosition; // 4
	private String shelfTrackNumber;// A1LSA4,A1RSA4--> link with product
	private String direction;// left,right L according to Aisle
	private OperationType operationType;
	private String aisleNumber;
	private String aisleLable;
	private String itemId;

}
