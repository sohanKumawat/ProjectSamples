package com.mb.demo.entity.common.picker;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.BaseOperationEntity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("unused")
@Entity
@Table(name = "picker_product_status")
@ApiModel(description = "Product picker status request data pojo ")
public class PickerProductStatusEntity extends BaseOperationEntity implements Serializable {
	private static final long serialVersionUID = -7879113573307072680L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long productId;
	private int totalProductQuantity = 0;
	private int acceptedProductQuantity = 0;
	private int remainingProductQuantity = 0;
	private int naItemQuantity;
	private OperationType picker_type;

	// private long availableQuantity;
	public long getRemainingItemQuantity() {
		return this.remainingProductQuantity = this.totalProductQuantity - this.acceptedProductQuantity;
	}

	public long getNaItemQuantity() {
		return this.naItemQuantity = this.totalProductQuantity - this.acceptedProductQuantity;
	}

}
