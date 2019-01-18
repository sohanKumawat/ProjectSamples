package com.mb.demo.entity.common.asset;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.mb.demo.beans.BaseBean;
import com.mb.demo.constants.PickPackConstants.ItemType;

import lombok.Data;
import lombok.EqualsAndHashCode;
/*
 * instead of this we can use itemScanner entity... this is parent child relation entity
 * 
 * */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="asset_item_mapping")
public class AssetItemStoreMappingEntity extends BaseBean implements Serializable {

	private static final long serialVersionUID = -5592574650376486428L;

	private long id;
	private String scanSequenceId;//Required or not
	private String assetId;//its id or barcode
	private ItemType assetType;
	private String itemId;//id or barcode
	private ItemType itemType;
	private String teamId;
	private String hubId;
	private String sheet;

}
