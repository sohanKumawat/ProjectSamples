package com.mb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.entity.common.node.NodeProductMappingEntity;
import com.mb.demo.repository.NodeProductMappingRespository;

@Service
public class NodeProductMappingService implements BasePickerServcie<NodeProductMappingEntity> {

	@Autowired
	NodeProductMappingRespository repository;


	@Override
	public NodeProductMappingEntity add(NodeProductMappingEntity entity) {
		return repository.save(entity);

	}

	@Override
	public NodeProductMappingEntity getById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<NodeProductMappingEntity> getAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

	@Override
	public NodeProductMappingEntity update(NodeProductMappingEntity entity) {
		return repository.save(entity);

	}

}