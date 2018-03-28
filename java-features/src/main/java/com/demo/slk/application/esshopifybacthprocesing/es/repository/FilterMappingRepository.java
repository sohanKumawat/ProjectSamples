package com.demo.slk.application.esshopifybacthprocesing.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.demo.slk.application.esshopifybacthprocesing.es.entity.PIProductFilterMapper;

@Repository
public interface FilterMappingRepository extends ElasticsearchRepository<PIProductFilterMapper, String> {

}
