package com.mb.demo.redis.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderProducts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 724240690374783673L;
	private long productId;
	private long hubId;
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
	private int quantity;

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		CustomerOrderProducts product = (CustomerOrderProducts) obj;
		return (product.productId == this.productId && product.productId == this.productId);
	}

	@Override
	public int hashCode() {
		return (int) this.productId;
	}

}
