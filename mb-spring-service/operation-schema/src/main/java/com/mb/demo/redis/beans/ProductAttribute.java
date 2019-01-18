package com.mb.demo.redis.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttribute implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3280076771446645512L;
	private long id;
	private String name;
	
	public static ProductAttribute newProductAttribute(long id,String name) {
		return new ProductAttribute(id,name);
	}

}
