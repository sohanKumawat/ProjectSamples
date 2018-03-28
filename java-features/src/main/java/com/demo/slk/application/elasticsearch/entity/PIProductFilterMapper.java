package com.demo.slk.application.elasticsearch.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "piproduct_filter_mapper", type = "piproduct_filter_mapper")
public class PIProductFilterMapper {
	private String botId;
	private String platform;
	private String clientFilter;
	private String pifilter;
	private String filterType;
}
