package com.demo.slk.application.esshopifybacthprocesing.es.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.demo.slk.application.esshopifybacthprocesing.es.entity.PIProductInventory;

@Repository
public interface ProductInvetoryRepository extends ElasticsearchRepository<PIProductInventory, String> {

	List<PIProductInventory> findByCategory(String category, Pageable pageable) throws Exception;

	Page<PIProductInventory> findByCategoryAndSubCategory1(String category, String subCategory1, Pageable pageable)
			throws Exception;

	Page<PIProductInventory> findByCategoryAndSubCategory2(String category, String subCategory1, Pageable pageable)
			throws Exception;

	Page<PIProductInventory> findByCategoryAndSubCategory1AndSubCategory2(String category, String subCategory1,
			String subCategory2, Pageable pageable) throws Exception;

	Page<PIProductInventory> findBySubCategory1(String subCategory1, Pageable pageable) throws Exception;

	Page<PIProductInventory> findBySubCategory1AndSubCategory2(String subCategory1, String subCategory2,
			Pageable pageable) throws Exception;

	Page<PIProductInventory> findBySubCategory1AndSubCategory2AndSubCategory3(String subCategory1, String subCategory2,
			String subCategory3, Pageable pageable) throws Exception;

}
