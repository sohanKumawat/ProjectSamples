package com.demo.slk.application.elasticsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "client_inventory_herarichy", type = "client_inventory_herarichy")
public class ClientInventoryHerarichy {
	@Id
	private String id;
	private String botId;
	private String platform;
	private String parentId;
	private String childId;
	private String status;

}
