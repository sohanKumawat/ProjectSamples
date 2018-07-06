package com.mb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.entity.common.ProductEntity;
import com.mb.demo.repository.product.ProductInventoryRepository;

@Service
public class ProductInventoryService {

	@Autowired
	ProductInventoryRepository productInventoryRepository;

	public ProductEntity save(ProductEntity product) {
		return productInventoryRepository.saveAndFlush(product);

	}

	public ProductEntity update(ProductEntity product) {
		return productInventoryRepository.saveAndFlush(product);
	}

	public ProductEntity findById(long id) {
		return productInventoryRepository.findById(id).orElse(null);
	}

	public List<ProductEntity> findAll() {
		return productInventoryRepository.findAll();
	}

	public List<ProductEntity> findByHubId(long hubId) {
		return productInventoryRepository.findByHubId(hubId);
	}

	public ProductEntity findByIdAndHubId(long id, long hubId) {
		return productInventoryRepository.findByIdAndHubId(id, hubId);
	}

}
