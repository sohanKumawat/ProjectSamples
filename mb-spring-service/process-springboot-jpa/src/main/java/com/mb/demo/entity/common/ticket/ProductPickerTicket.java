package com.mb.demo.entity.common.ticket;

import java.io.Serializable;

import com.mb.demo.constants.PickPackConstants.ItemType;
import com.mb.demo.constants.PickPackConstants.OperationType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("unused")
public class ProductPickerTicket extends NAProductTicket implements Serializable {
	private static final long serialVersionUID = 1303413705685501415L;
	private String teamId;
	private OperationType pickerType;
	private int requiredItemQuantity;
	private int acceptedItemQuantity;
	private int remainingItemQuantity;
	private int naItemQuantity;

	/*
	 * parentId used as parent child relationship. like crate belong to order and
	 * product belong to order. It's kind of mapping
	 * 
	 */
	private String parantItemId; // orderId

	private ItemType parentItemType; // order

	public long getNaItemQuantity() {
		return this.naItemQuantity = this.remainingItemQuantity;
	}
}
