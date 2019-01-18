package com.mb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.entity.common.ProductInventoryEntity;
import com.mb.demo.repository.product.ProductInventoryRepository;

@Service
public class ProductInventoryService {

	@Autowired
	ProductInventoryRepository productInventoryRepository;

	public ProductInventoryEntity save(ProductInventoryEntity product) {
		return productInventoryRepository.saveAndFlush(product);

	}

	public ProductInventoryEntity update(ProductInventoryEntity product) {
		return productInventoryRepository.saveAndFlush(product);
	}

	public ProductInventoryEntity findById(long id) {
		return productInventoryRepository.findById(id).orElse(null);
	}

	public List<ProductInventoryEntity> findAll() {
		return productInventoryRepository.findAll();
	}

	public List<ProductInventoryEntity> findByHubId(long hubId) {
		return productInventoryRepository.findByHubId(hubId);
	}

	public ProductInventoryEntity findByIdAndHubId(long id, long hubId) {
		return productInventoryRepository.findByIdAndHubId(id, hubId);
	}

}
