package com.demo.slk.application.esshopifybacthprocesing.es.entity;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
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
	private String subCategory3;
	private String productId;
	private String updatedAt;
	private String publishedAt;
	private String  productType;
	private List<String> tags;
	private String imageUrl;
	private int availableQuantity;
	private String status;
	private String type;
	private double price;
	private String filter1Key;
	private String filter1Value;
	private String filter2Key;
	private String filter2Value;
	private String filter3Key;
	private String filter3Value;
	private String filter4Key;
	private String filter4Value;
	private String filter5Key;
	private String filter5Value;
	private String filter6Key;
	private String filter6Value;
}
