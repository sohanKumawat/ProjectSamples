package com.mb.demo.beans;

import java.io.Serializable;

import com.mb.demo.constants.PickPackConstants.OperationType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ShelfProductTrackerBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 5493753340014475927L;
	private long id;
	private String sourceShelfTrackNumber;
	private String targetShelfTrackNumber;
	private long sourceShelfId;
	private long targetShelfId;
	private long sourceAisleId;
	private long targetAisleId;
	private String sourceAisleName;
	private String targetAisleName;
	private OperationType shelfArea;
	private long productId;
}
