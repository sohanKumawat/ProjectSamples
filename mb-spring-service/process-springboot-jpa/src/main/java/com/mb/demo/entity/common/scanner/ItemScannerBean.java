package com.mb.demo.entity.common.scanner;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.mb.demo.constants.PickPackConstants.ItemType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "item_scanner")
public class ItemScannerBean extends BaseScannerBean implements Serializable {

	private static final long serialVersionUID = 5988841507833731588L;

	private long id;

	@NotBlank
	private String itemId;

	@NotBlank
	private ItemType itemType;

	@NotBlank
	private String teamId;

	@NotBlank
	private String hubId;

	@NotBlank
	private String sheet;// "1","2","3"

	/*
	 * parentId used as parent child relationship. like crate belong to order and
	 * product belong to order. It's kind of mapping
	 * 
	 */
	private String parantId = "-1";// in case self is -1

	private ItemType parentType = ItemType.PRODUCT;

	public static ItemScannerBean getInstance() {
		return new ItemScannerBean();
	}

}
