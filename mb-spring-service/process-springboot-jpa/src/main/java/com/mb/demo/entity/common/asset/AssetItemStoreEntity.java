package com.mb.demo.entity.common.asset;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.mb.demo.beans.BaseBean;
import com.mb.demo.constants.PickPackConstants.ItemType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="asset_item_store")
public class AssetItemStoreEntity extends BaseBean implements Serializable {
	private static final long serialVersionUID = -8036543681029381579L;
	private long id;
	private String itemId;
	private ItemType itemType;
	private long assetItemMappingId;
	private long quantity;
}
