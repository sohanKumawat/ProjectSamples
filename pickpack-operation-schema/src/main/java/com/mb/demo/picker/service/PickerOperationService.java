package com.mb.demo.picker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.entity.common.picker.PickerProductStatusEntity;
import com.mb.demo.repository.picker.PickerProductStratusRepository;
import com.mb.demo.service.BasePickerServcie;

@Service
public class PickerOperationService implements BasePickerServcie<PickerProductStatusEntity> {

	@Autowired
	PickerProductStratusRepository repository;

	@Override
	public void add(PickerProductStatusEntity entity) {
		repository.save(entity);

	}

	@Override
	public PickerProductStatusEntity getById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<PickerProductStatusEntity> getAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

	@Override
	public void update(PickerProductStatusEntity entity) {
		repository.save(entity);

	}
}
