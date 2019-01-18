package com.mb.demo.entity.common.shelf;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.mb.demo.beans.BaseBean;
import com.mb.demo.constants.PickPackConstants.OperationType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "self_product_mapping")
public class ShelfProductMappingEntity extends BaseBean implements Serializable {

	private static final long serialVersionUID = -5592574650376486428L;
	private long id;
	@NotBlank
	private String hubId;
	private String sheet;
	@NotBlank
	private String productId;
	private OperationType productArea;
	private String sourceAisleId;
	private String targetAisleId;
	private String sourceShelfTrackNumber;
	@SuppressWarnings("unused")
	private OperationType sourceShelfArea;
	private String targetShelfTrackNumber;
	private OperationType targetShelfArea;

	public OperationType getSourceShelfArea() {
		return this.sourceShelfArea = this.productArea;
	}

}
