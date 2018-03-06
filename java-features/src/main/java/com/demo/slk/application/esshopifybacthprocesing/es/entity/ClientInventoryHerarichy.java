package com.demo.slk.application.esshopifybacthprocesing.es.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.DataItemWrite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Document(indexName = "client_inventory_herarichy", type = "client_inventory_herarichy")
public class ClientInventoryHerarichy extends DataItemWrite {
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
