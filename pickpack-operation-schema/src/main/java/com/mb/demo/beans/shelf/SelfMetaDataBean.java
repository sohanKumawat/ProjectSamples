package com.mb.demo.beans.shelf;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.mb.demo.beans.BaseBean;
import com.mb.demo.constants.PickPackConstants.OperationType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class SelfMetaDataBean extends BaseBean implements Serializable {
	private static final long serialVersionUID = -1242877604728534782L;
	private long id;
	@NotBlank
	private String hubId;
	@NotBlank
	private String sheet;
	private String shelfNumber;// SA
	private String cellPosition; // 4
	private String shelfTrackNumber;// A1LSA4,A1RSA4--> link with product
	private String direction;// left,right L according to Aisle
	private OperationType operationType;
	private long aisleId;
}
