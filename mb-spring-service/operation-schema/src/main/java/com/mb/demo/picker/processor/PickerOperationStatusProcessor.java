package com.mb.demo.picker.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.node.NodeStorageDataEntity;
import com.mb.demo.entity.common.node.ProductNodeStoreEntity;
import com.mb.demo.redis.processor.processor;
import com.mb.demo.service.NodeStorageDataService;
import com.mb.demo.service.ProductNodeStoreService;

@processor
public class PickerOperationStatusProcessor {
	@Autowired
	ProductNodeStoreService productNodeStoreService;
	@Autowired
	NodeStorageDataService nodeStorageDataService;

	public ProductNodeStoreEntity updateProductNodeStore(ProductNodeStoreEntity productNodeStore) {
		List<ProductNodeStoreEntity> nodeProducts = productNodeStoreService.findProducts(
				productNodeStore.getProductId(), productNodeStore.getHubId(), productNodeStore.getTeamId(),
				productNodeStore.getNodeId(), productNodeStore.getSheet());
		if (nodeProducts != null && nodeProducts.size() > 0) {
			ProductNodeStoreEntity existProductStore = nodeProducts.get(0);
			existProductStore.setAvailableQuantity(
					existProductStore.getAvailableQuantity() + productNodeStore.getTotalQuantity());
			existProductStore
					.setTotalQuantity(existProductStore.getTotalQuantity() + productNodeStore.getTotalQuantity());
			productNodeStoreService.add(existProductStore);
		} else {
			productNodeStore.setAvailableQuantity(productNodeStore.getTotalQuantity());
			productNodeStoreService.add(productNodeStore);
		}

		return nodeProducts != null && nodeProducts.size() > 0 ? nodeProducts.get(0) : productNodeStore;
	}

	public List<ProductNodeStoreEntity> findNodeProductStore(long hubId, long teamId, long productId, String sheet) {
		List<ProductNodeStoreEntity> nodeProducts = productNodeStoreService.findProducts(productId, hubId, teamId,
				sheet);
		return nodeProducts;
	}

	public List<ProductNodeStoreEntity> findNodeProductStore(long hubId, long teamId, long productId, String sheet,
			OperationType pickerType) {
		List<ProductNodeStoreEntity> nodeProducts = productNodeStoreService.findProducts(productId, hubId, teamId,
				sheet, pickerType);
		return nodeProducts;
	}

	public List<ProductNodeStoreEntity> findNodeStore(long hubId, long nodeId, String sheet, OperationType pickerType) {
		List<ProductNodeStoreEntity> nodeProducts = productNodeStoreService.findProducts(hubId, nodeId, pickerType);
		return nodeProducts;
	}

	public NodeStorageDataEntity findNodeStorageData(long hubId, String scannerCode, String sheet) {
		return nodeStorageDataService.findByHubIdAndScannerCodeAndSheet(hubId, scannerCode, sheet);
	}

	public ProductNodeStoreEntity updateProductNodeStore(ProductNodeStoreEntity productNodeStore, String scannerCode) {
		NodeStorageDataEntity nodeStorageData = findNodeStorageData(productNodeStore.getHubId(), scannerCode,
				productNodeStore.getSheet());
		productNodeStore.setNodeId(nodeStorageData.getId());
		productNodeStore.setNodeTracker(nodeStorageData.getTrackerNumber());
		return updateProductNodeStore(productNodeStore);

	}
}
