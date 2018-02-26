package com.demo.slk.application.elasticsearch.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

public class ElasticSearchManager {
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	String articleTitle = "Spring Data Elasticsearch";
	
	public void  searchByCategory(String category){
		/*SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("title", articleTitle).minimumShouldMatch("75%"))
				.withFilter(FilterBuilder.boolFilter().must(FilterBuilder.termFilter("id", "dscs"))).build();

		Page<SampleEntity> sampleEntities = elasticsearchTemplate.queryForPage(searchQuery, SampleEntity.class);*/
	}
	
}
