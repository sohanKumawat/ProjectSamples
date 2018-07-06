package com.mb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.entity.common.metaData.AssetMedaDataEntity;
import com.mb.demo.repository.AssetDataRepository;

@Service
public class AssetDataService implements BasePickerServcie<AssetMedaDataEntity> {

	@Autowired
	AssetDataRepository repository;

	@Override
	public void add(AssetMedaDataEntity entity) {
		repository.save(entity);

	}

	@Override
	public AssetMedaDataEntity getById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<AssetMedaDataEntity> getAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

	@Override
	public void update(AssetMedaDataEntity entity) {
		repository.save(entity);

	}

}
