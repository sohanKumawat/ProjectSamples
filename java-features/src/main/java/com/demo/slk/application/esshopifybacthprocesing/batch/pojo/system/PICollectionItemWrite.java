package com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
//@Document(indexName = "piproduct_inventory", type = "piproduct_inventory")
public class PICollectionItemWrite extends DataItemWrite {
	@Id
	private String id;
	private String botId;
	private String platform;
	private String parentId;
	private String childId;
	private String title;
	private String name;
	private String description;
	private String imageUrl;
	private String type;
	private String status;
	private String createddAt;
	private String updatedAt;
}
