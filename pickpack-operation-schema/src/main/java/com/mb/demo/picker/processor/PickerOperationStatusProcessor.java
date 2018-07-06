package com.mb.demo.picker.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.node.ProductNodeStoreEntity;
import com.mb.demo.redis.processor.processor;
import com.mb.demo.service.ProductNodeStoreService;

@processor
public class PickerOperationStatusProcessor {
	@Autowired
	ProductNodeStoreService productNodeStoreService;

	public void updateProductNodeStore(ProductNodeStoreEntity productNodeStore) {
		List<ProductNodeStoreEntity> nodeProducts = productNodeStoreService
				.findByProductIdAndHubIdAndTeamIdAndNodeIdAndSheet(productNodeStore.getProductId(),
						productNodeStore.getHubId(), productNodeStore.getTeamId(), productNodeStore.getNodeId(),
						productNodeStore.getSheet());
		if (nodeProducts != null && nodeProducts.size() > 0) {
			ProductNodeStoreEntity extProductStore = nodeProducts.get(0);
			extProductStore.setAvailableQuantity(productNodeStore.getTotalQuantity());
			extProductStore.setTotalQuantity(productNodeStore.getTotalQuantity());
		} else {
			productNodeStore.setAvailableQuantity(productNodeStore.getTotalQuantity());
			productNodeStoreService.add(productNodeStore);
		}
	}

	public List<ProductNodeStoreEntity> findNodeProductStore(long hubId, long teamId, long productId, String sheet) {
		List<ProductNodeStoreEntity> nodeProducts = productNodeStoreService
				.findByProductIdAndHubIdAndTeamIdAndSheet(productId, hubId, teamId, sheet);
		return nodeProducts;
	}

	public List<ProductNodeStoreEntity> findNodeProductStore(long hubId, long teamId, long productId, String sheet,
			OperationType pickerType) {
		List<ProductNodeStoreEntity> nodeProducts = productNodeStoreService
				.findByProductIdAndHubIdAndTeamIdAndSheetAndNodeArea(productId, hubId, teamId, sheet,pickerType);
		return nodeProducts;
	}
}
