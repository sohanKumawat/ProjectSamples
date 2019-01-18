package com.mb.demo.beans.metadata;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.mb.demo.beans.BaseBean;
import com.mb.demo.constants.PickPackConstants.ItemType;
import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.constants.PickPackConstants.ScannerCodeType;

import lombok.Data;
import lombok.EqualsAndHashCode;
/*
 * 
 * */
@Data
@EqualsAndHashCode(callSuper = false)
public class AssetMedaDataBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = -1326652213975920791L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private String name;
	private String hubId;
	private OperationType operationType;
	private String description;
	@Column(unique = true)
	private String scannerCode;
	@NotBlank
	private ScannerCodeType scannerCodeType = ScannerCodeType.QRCODE;
	@NotBlank
	private ItemType type;
}
