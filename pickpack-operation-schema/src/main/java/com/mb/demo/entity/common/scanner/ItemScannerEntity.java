package com.mb.demo.entity.common.scanner;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.mb.demo.beans.scanner.BaseScannerBean;
import com.mb.demo.beans.scanner.ItemScannerBean;
import com.mb.demo.constants.PickPackConstants.ItemType;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "item_scanner")
@ApiModel(description = "Item scanner request data pojo ")
public class ItemScannerEntity extends BaseScannerBean implements Serializable {

	private static final long serialVersionUID = 5988841507833731588L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private long itemId;

	@NotBlank
	private ItemType itemType;

	@NotBlank
	private long teamId;

	@NotBlank
	private String hubId;

	@NotBlank
	private String sheet;// "1","2","3"

	/*
	 * parentId used as parent child relationship. like crate belong to order and
	 * product belong to order. It's kind of mapping
	 * 
	 */
	private long parantId = -1;// in case self is -1

	private ItemType parentType = ItemType.PRODUCT;

	public static ItemScannerBean getInstance() {
		return new ItemScannerBean();
	}

}
