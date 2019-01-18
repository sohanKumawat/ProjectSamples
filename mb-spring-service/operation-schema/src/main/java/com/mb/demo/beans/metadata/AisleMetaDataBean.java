package com.mb.demo.beans.metadata;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.mb.demo.beans.BaseBean;
import com.mb.demo.constants.PickPackConstants.OperationType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AisleMetaDataBean extends BaseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@NotBlank
	private String hubId;
	@NotBlank
	private String sheet;
	@NotBlank
	private OperationType aisleAreaType;
	@NotBlank
	private String aisleName; //A1

	private int maxPicker;// person for aisle
	private int maxPickerItemQuantity;// per person

	/*
	 * private List<String> categoryId; private List<String> subCategoryid;
	 */
}
