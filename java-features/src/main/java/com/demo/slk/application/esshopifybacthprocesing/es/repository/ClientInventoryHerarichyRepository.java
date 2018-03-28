package com.demo.slk.application.esshopifybacthprocesing.es.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.demo.slk.application.esshopifybacthprocesing.es.entity.ClientInventoryHerarichy;

@Repository
public interface ClientInventoryHerarichyRepository extends ElasticsearchRepository<ClientInventoryHerarichy, String> {

	List<ClientInventoryHerarichy> findByBotId(String botId, Pageable pageable) throws Exception;

	Page<ClientInventoryHerarichy> findByBotIdAndParentId(String botId, String parentId, Pageable pageable)
			throws Exception;

	Page<ClientInventoryHerarichy> findByBotIdAndParentIdAndChildId(String botId, String parentId, String childId,
			Pageable pageable) throws Exception;

	Page<ClientInventoryHerarichy> findByBotIdAndChildId(String botId, String childId, Pageable pageable)
			throws Exception;

}
