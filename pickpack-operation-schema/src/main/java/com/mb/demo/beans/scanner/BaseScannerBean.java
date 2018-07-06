package com.mb.demo.beans.scanner;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import com.mb.demo.beans.BaseBean;
import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.constants.PickPackConstants.ScannerCodeType;
import com.mb.demo.constants.PickPackConstants.ScannerType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public class BaseScannerBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 5988841507833731588L;

	@NotBlank
	private String scannerCode;

	@NotBlank
	private OperationType scannerLevel;

	private ScannerCodeType scannerCodeType = ScannerCodeType.QRCODE;

	private ScannerType scannerType = ScannerType.SYSTEM;
	private int itemQuantity = 1;// in case of manual insertion, We can maintain quantity else its just take
	// default quantity
	@NotBlank
	private String description;

	public static BaseScannerBean getInstance() {
		return new BaseScannerBean();
	}

}
