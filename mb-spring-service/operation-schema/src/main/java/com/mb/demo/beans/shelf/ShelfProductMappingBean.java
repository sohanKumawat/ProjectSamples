package com.mb.demo.beans.shelf;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.mb.demo.beans.BaseBean;
import com.mb.demo.constants.PickPackConstants.OperationType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ShelfProductMappingBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 843944954115962607L;
	private long id;
	@NotBlank
	private long productId;
	@NotBlank
	private String hubId;
	private String sheet;
	private OperationType productArea;
	private long sourceAisleId;
	private long targetAisleId;
	private long sourceShelfId;
	private long targetShelfId;

}
