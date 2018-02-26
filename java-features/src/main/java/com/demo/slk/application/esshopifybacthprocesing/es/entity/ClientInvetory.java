package com.demo.slk.application.esshopifybacthprocesing.es.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "client_invetory", type = "client_invetory")
public class ClientInvetory {
	@Id
	private String id;
	private String name;
	private String url;
	private String searchKeywords;
	private String searchMappingFilter;
}
