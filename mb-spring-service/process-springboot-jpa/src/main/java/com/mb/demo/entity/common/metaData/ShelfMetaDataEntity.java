package com.mb.demo.entity.common.metaData;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.mb.demo.beans.BaseBean;
import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.constants.PickPackConstants.ScannerCodeType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 * How to maintain shelfTrackNumber unique -> if SA AND FA have same aisle number and shelfName
 * 
 * */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "shelf_meta_data")
public class ShelfMetaDataEntity extends BaseBean implements Serializable {

	private static final long serialVersionUID = 5733486049376451718L;
	private long id;
	@NotBlank
	private String hubId;
	@NotBlank
	private String sheet;
	private String shelfName;// SA
	private String beanNumber; // 4
	@Column(unique = true)
	private String scannerCode;

	private ScannerCodeType scannerCodeType = ScannerCodeType.QRCODE;

	@Column(unique = true)
	private String shelfTrackNumber;// A1LSA4,A1RSA4--> link with product
	// private String direction;// left,right L according to Aisle
	private OperationType shelfAreaType;
	private String aisleId;// A1,A2,A3

	public String getShelfTrackNumber() {
		// return this.shelfTrackNumber = this.aisleId + this.direction +
		// this.shelfNumber + this.cellPosition;
		return this.shelfTrackNumber = this.aisleId + "-" + this.shelfName + "-" + this.beanNumber;
	}

}
