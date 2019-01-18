package com.mb.demo.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
// @MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public class BaseProductAttribute extends BaseBean implements Serializable {
	private static final long serialVersionUID = -7879113573307072880L;
	@NotBlank
	private long productId;
	private String hubId;
	private String sheet;
	@NotBlank
	private String name;
	private String size;
	private double price;
	@NotBlank
	private String scannerCode;
	private long categoryId;
	private long subcategoryId;
	private String image;
	private String type;
	private String description;
	private String packingType;

}
