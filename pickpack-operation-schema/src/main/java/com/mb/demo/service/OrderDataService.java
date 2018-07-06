package com.mb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.entity.common.owner.OrderAssetItemStoreEntity;
import com.mb.demo.repository.order.OrderDataProcessingRepository;

@Service
public class OrderDataService implements BasePickerServcie<OrderAssetItemStoreEntity> {

	@Autowired
	OrderDataProcessingRepository repository;

	@Override
	public void add(OrderAssetItemStoreEntity entity) {
		repository.save(entity);

	}

	@Override
	public OrderAssetItemStoreEntity getById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<OrderAssetItemStoreEntity> getAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

	@Override
	public void update(OrderAssetItemStoreEntity entity) {
		repository.save(entity);

	}

}
