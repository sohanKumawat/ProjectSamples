package com.mb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.entity.common.node.NodeStorageDataEntity;
import com.mb.demo.repository.NodeStorageDataRepository;

@Service
public class NodeStorageDataService implements BasePickerServcie<NodeStorageDataEntity> {

	@Autowired
	NodeStorageDataRepository repository;

	@Override
	public void add(NodeStorageDataEntity entity) {
		repository.save(entity);

	}

	@Override
	public NodeStorageDataEntity getById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<NodeStorageDataEntity> getAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

	@Override
	public void update(NodeStorageDataEntity entity) {
		repository.save(entity);

	}

}