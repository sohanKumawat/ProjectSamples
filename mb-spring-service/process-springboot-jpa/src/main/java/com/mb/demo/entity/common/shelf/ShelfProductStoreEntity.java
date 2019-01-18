package com.mb.demo.entity.common.shelf;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.mb.demo.beans.BaseBean;
import com.mb.demo.constants.PickPackConstants.OperationType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "shelf_product_store")
public class ShelfProductStoreEntity extends BaseBean implements Serializable {

	private static final long serialVersionUID = -1805039523544179392L;
	private long id;
	private long selfProductMappingId;
	private int priority = 1;// 1,2,3 -> 1 means main cell but it's full then picker can keep item nearby
	private OperationType shelfArea;// = AreaTypes.SA; // FA,STA,SA,OWNER // cell,
	private int totalQuantity;//
	private int availableQuantity;//
	private int inUseQuantity;

}
