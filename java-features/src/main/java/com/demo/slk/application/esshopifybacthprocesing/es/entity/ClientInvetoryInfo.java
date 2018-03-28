package com.demo.slk.application.esshopifybacthprocesing.es.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "client_invetory", type = "client_invetory")
public class ClientInvetoryInfo {
	@Id
	private String id;
	private String name;
	private String url;
	private String searchKeywords;
	private List<ClientInvetory> inventories;

}
