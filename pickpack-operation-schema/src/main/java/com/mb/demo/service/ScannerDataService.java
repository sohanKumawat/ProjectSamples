package com.mb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.entity.common.scanner.ItemScannerEntity;
import com.mb.demo.repository.ScannerDataRepository;

@Service
public class ScannerDataService implements BasePickerServcie<ItemScannerEntity> {

	@Autowired
	ScannerDataRepository repository;

	@Override
	public ItemScannerEntity add(ItemScannerEntity entity) {
		return repository.save(entity);

	}

	@Override
	public ItemScannerEntity getById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<ItemScannerEntity> getAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

	@Override
	public ItemScannerEntity update(ItemScannerEntity entity) {
		return repository.save(entity);

	}

}
