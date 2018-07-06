package com.mb.demo.entity.common.metaData;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.mb.demo.constants.PickPackConstants.ItemType;
import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.constants.PickPackConstants.ScannerCodeType;
import com.mb.demo.entity.common.BaseEntity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
/*
 * 
 * */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="asset_meta_data")
@ApiModel(description = "Asset meta data request pojo ")
public class AssetMedaDataEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1326652213975920791L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private String name;// SA
	private String hubId;
	private String description;;// SA
	@Column(unique = true)
	private String scannerCode;
	private OperationType operationType;
	@NotBlank
	private ScannerCodeType scannerCodeType = ScannerCodeType.QRCODE;
	@NotBlank
	private ItemType type;
	private int flag;
}
