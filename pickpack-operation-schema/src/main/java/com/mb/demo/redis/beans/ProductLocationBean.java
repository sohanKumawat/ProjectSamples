package com.mb.demo.redis.beans;

import java.io.Serializable;

import com.mb.demo.constants.PickPackConstants.OperationType;

import lombok.Data;
import lombok.experimental.Builder;

@Data
@Builder
public class ProductLocationBean implements Serializable {
	private static final long serialVersionUID = -2057333239636845817L;
	private long hubId;
	private long productId;
	private long locationId;
	private String locationName;
	private String locationTitle;
	private String locationTrackerNumber; // 4
	private String locationScannerCode; // 4
	private OperationType locationArea;
	private String locationDescription;// SA
}
