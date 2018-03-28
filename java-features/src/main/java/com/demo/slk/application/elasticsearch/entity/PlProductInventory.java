package com.demo.slk.application.elasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "piproduct_inventory", type = "piproduct_inventory")
public class PlProductInventory {
	@Id
	private String id;
	private String botId;
	private String category;
	private String subCategory1;
	private String subCategory2;
	private String productId;
	private int availableQuantity;
	private String status;
	private String type;
	private double price;
	private String filter1;
	private String filter2;
	private String filter3;
	private String filter4;
	private double filter5;
	private double filter6;
	private double filter7;
	private double filter8;
	private String filter9;
	private String filter10;

}
