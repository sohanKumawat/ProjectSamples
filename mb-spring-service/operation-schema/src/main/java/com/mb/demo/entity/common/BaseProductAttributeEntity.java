
package com.mb.demo.entity.common;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public class BaseProductAttributeEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7098662752366632719L;
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
