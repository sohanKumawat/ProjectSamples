package com.mb.demo.entity.common.asset;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.mb.demo.beans.BaseBean;
import com.mb.demo.constants.PickPackConstants.ItemType;
import com.mb.demo.constants.PickPackConstants.ScannerCodeType;

import lombok.Data;
import lombok.EqualsAndHashCode;
/*
 * 
 * */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="asset_meta_data")
public class AssetMedaDataEntity extends BaseBean implements Serializable {

	private static final long serialVersionUID = -1326652213975920791L;

	private long id;
	private String assetId;// SA
	private String hubId;
	private String assetDescription;;// SA
	@Column(unique = true)
	private String scannerCode;
	@NotBlank
	private ScannerCodeType scannerCodeType = ScannerCodeType.QRCODE;
	@NotBlank
	private ItemType assetType;
}
