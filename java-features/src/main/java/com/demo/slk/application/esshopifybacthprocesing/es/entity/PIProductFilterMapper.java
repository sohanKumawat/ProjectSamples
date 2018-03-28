package com.demo.slk.application.esshopifybacthprocesing.es.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "piproduct_filter_mapper", type = "piproduct_filter_mapper")
public class PIProductFilterMapper {
	@Id
	private String id;
	private String botId;
	private String platform;
	private String clientFilter;
	private String pifilter;
}
