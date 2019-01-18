package com.mb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.constants.PickPackConstants.StorageNode;
import com.mb.demo.entity.common.node.NodeStorageDataEntity;
import com.mb.demo.repository.NodeStorageDataRepository;

@Service
public class NodeStorageDataService implements BasePickerServcie<NodeStorageDataEntity> {

	@Autowired
	NodeStorageDataRepository repository;

	@Override
	public NodeStorageDataEntity add(NodeStorageDataEntity entity) {
		return repository.save(entity);

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
	public NodeStorageDataEntity update(NodeStorageDataEntity entity) {
		return repository.save(entity);

	}

	public NodeStorageDataEntity findByHubIdAndScannerCodeAndNodeArea(long hubId, String scannerCode,
			OperationType nodeArea) {
		return repository.findByHubIdAndScannerCodeAndNodeArea(hubId, scannerCode, nodeArea);
	}

	public NodeStorageDataEntity findByHubIdAndScannerCodeAndNodeAreaAndStorageItemType(long hubId, String scannerCode,
			OperationType nodeArea, StorageNode storageItemType) {
		return repository.findByHubIdAndScannerCodeAndNodeAreaAndStorageItemType(hubId, scannerCode, nodeArea,
				storageItemType);
	}

	public NodeStorageDataEntity findByHubIdAndScannerCode(long hubId, String scannerCode) {
		return repository.findByHubIdAndScannerCode(hubId, scannerCode);
	}

	public NodeStorageDataEntity findByHubIdAndScannerCodeAndTrackerNumber(long hubId,String scannerCode, String trackerNumber) {
		return repository.findByHubIdAndScannerCodeAndTrackerNumber(hubId,scannerCode, trackerNumber);
	}

	public NodeStorageDataEntity findByHubIdAndTrackerNumber(long hubId, String trackerNumber) {
		return repository.findByHubIdAndTrackerNumber(hubId, trackerNumber);
	}

	public NodeStorageDataEntity findByIdAndHubId(long hubId, String scannerCode) {
		return repository.findByIdAndHubId(hubId, scannerCode);
	}

	public NodeStorageDataEntity findByHubIdAndScannerCodeAndSheet(long hubId, String scannerCode, String sheet) {
		return repository.findByHubIdAndScannerCodeAndSheet(hubId, scannerCode, sheet);
	}

}