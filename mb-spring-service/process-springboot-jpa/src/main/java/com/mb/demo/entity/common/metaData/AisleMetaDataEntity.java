package com.mb.demo.entity.common.metaData;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name = "aisle_meta_data")
public class AisleMetaDataEntity extends BaseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;

	@NotBlank
	private String hubId;
	@NotBlank
	private String sheet;
	@NotBlank
	private OperationType aisleAreaType;
	@Column(unique = true)
	private String aisleId;// A1
	@NotBlank
	private String aisleName;

	private int maxPicker;// person for aisle
	private int maxPickerItemQuantity;// per person

	public String getAisleName() {
		return this.aisleName = this.aisleId;
	}
	/*
	 * private List<String> categoryId; private List<String> subCategoryid;
	 */
}
