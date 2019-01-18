package com.mb.demo.entity.sa;

import java.io.Serializable;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.BaseProductAttribute;

import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 * join between ProductPickerStatusEntity and basket products
 * 
 * */
@Data
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("unused")
public class ProductPickerAttributeBean extends BaseProductAttribute implements Serializable {

	private static final long serialVersionUID = 9193806472185648905L;
	private String teamId;
	private int totalProductQuantity;// get from
	private int acceptedProductQuantity = 0;
	private int remainingProductQuantity = 0;
	private int naProductQuantity = 0;
	private OperationType pickerType;

	// private long availableQuantity;
	public long getRemainingProductQuantity() {
		return this.remainingProductQuantity = this.totalProductQuantity - this.acceptedProductQuantity;
	}

	public long getNaProductQuantity() {
		return this.naProductQuantity = this.totalProductQuantity - this.acceptedProductQuantity;
	}
}
