package com.demo.slk.application.esshopifybacthprocesing.es.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.slk.application.esshopifybacthprocesing.es.entity.PIProductInventory;
import com.demo.slk.application.esshopifybacthprocesing.es.repository.ProductInvetoryRepository;

@Service
public class ProductInventoryService implements BaseCurdService {

	@Autowired
	ProductInvetoryRepository productInventoryRepository;

	@Override
	public <T> void save(T t) {
		productInventoryRepository.save((PIProductInventory) t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T findAll() {
		return (T) (List<PIProductInventory>) productInventoryRepository.findAll();
	}

	@Override
	public <T> void update(T t) {

	}

	public List<PIProductInventory> findByCategory(String category, Pageable pageable) throws Exception {
		return productInventoryRepository.findByCategory(category, pageable);
	}

	public Page<PIProductInventory> findByCategoryAndSubCategory1(String category, String subCategory1,
			Pageable pageable) throws Exception{
		return productInventoryRepository.findByCategoryAndSubCategory1(category, subCategory1, pageable);
	}

	public Page<PIProductInventory> findByCategoryAndSubCategory2(String category, String subCategory1,
			Pageable pageable) throws Exception{
		return productInventoryRepository.findByCategoryAndSubCategory2(category, subCategory1, pageable);
	}

	public Page<PIProductInventory> findByCategoryAndSubCategory1AndSubCategory2(String category, String subCategory1,
			String subCategory2, Pageable pageable) throws Exception{
		return productInventoryRepository.findByCategoryAndSubCategory1AndSubCategory2(category, subCategory1,
				subCategory2, pageable);
	}

	public Page<PIProductInventory> findBySubCategory1(String subCategory1, Pageable pageable) throws Exception{
		return productInventoryRepository.findBySubCategory1(subCategory1, pageable);
	}

	/*public Page<PIProductInventory> findBySubCategory1AndSubCategory2(String subCategory1, String subCategory2,
			Pageable pageable) throws Exception{
		return productInventoryRepository.findBySubCategory1AndSubCategory2(subCategory1, subCategory2, pageable);
	}

	public Page<PIProductInventory> findBySubCategory1AndSubCategory2AndsubCategory3(String subCategory1,
			String subCategory2, String subCategory3, Pageable pageable) throws Exception{
		return productInventoryRepository.findBySubCategory1AndSubCategory2AndsubCategory3(subCategory1, subCategory2,
				subCategory3, pageable);
	}*/

}
