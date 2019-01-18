package com.mb.demo.entity.common.picker;

import java.io.Serializable;

import com.mb.demo.entity.common.BaseOperationBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductPickerStatusBean extends BaseOperationBean implements Serializable {
	private static final long serialVersionUID = -7879113573307072680L;
	private int id;
	private int totalProductQuantity = 0;
	private int acceptedProductQuantity = 0;
	private long naProductQuantity;
	private int remainingProductQuantity = 0;
	private long shelfProductMappingId;

	// private long availableQuantity;
	public long getRemainingItemQuantity() {
		return this.naProductQuantity = this.totalProductQuantity - this.acceptedProductQuantity;
	}

	public long getNaItemQuantity() {
		return this.remainingProductQuantity = this.totalProductQuantity - this.acceptedProductQuantity;
	}

}