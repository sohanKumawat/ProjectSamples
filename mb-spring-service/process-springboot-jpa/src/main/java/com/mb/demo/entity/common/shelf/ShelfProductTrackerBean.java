package com.mb.demo.entity.common.shelf;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.BaseOperationBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ShelfProductTrackerBean extends BaseOperationBean implements Serializable {

	private static final long serialVersionUID = 843944954115962607L;
	private long id;
	@NotBlank
	private String productId;
	@NotBlank
	private String hubId;
	private String sheet;
	private OperationType productArea;
	private String sourceAisleId;
	private String targetAisleId;
	private String sourceShelfTrackNumber;
	@SuppressWarnings("unused")
	private OperationType sourceShelfArea;
	private String targetShelfTrackNumber;
	private OperationType targetShelfArea;

	public OperationType getSourceShelfArea() {
		return this.sourceShelfArea = this.productArea;
	}
}
