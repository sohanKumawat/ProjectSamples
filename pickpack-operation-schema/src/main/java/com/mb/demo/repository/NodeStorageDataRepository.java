package com.mb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.constants.PickPackConstants.StorageNode;
import com.mb.demo.entity.common.node.NodeStorageDataEntity;

@Repository
public interface NodeStorageDataRepository extends JpaRepository<NodeStorageDataEntity, Long> {

	public NodeStorageDataEntity findByHubIdAndScannerCodeAndNodeArea(long hubId, String scannerCode,
			OperationType nodeArea);

	public NodeStorageDataEntity findByHubIdAndScannerCodeAndNodeAreaAndStorageItemType(long hubId, String scannerCode,
			OperationType nodeArea, StorageNode storageItemType);

	public NodeStorageDataEntity findByHubIdAndScannerCode(long hubId, String scannerCode);

	public NodeStorageDataEntity findByHubIdAndScannerCodeAndTrackerNumber(long hubId,String scannerCode, String trackerNumber);

	public NodeStorageDataEntity findByHubIdAndTrackerNumber(long hubId, String trackerNumber);

	public NodeStorageDataEntity findByIdAndHubId(long hubId, String scannerCode);

	public NodeStorageDataEntity findByHubIdAndScannerCodeAndSheet(long hubId, String scannerCode, String sheet);

}
