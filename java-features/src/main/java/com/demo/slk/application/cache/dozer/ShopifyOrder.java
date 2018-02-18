package com.demo.slk.application.cache.dozer;

import org.dozer.Mapping;

import lombok.Data;

@Data
public class ShopifyOrder {
	@Mapping("gname")
	private String name;
	@Mapping("gsal")
	private String sal;

}
