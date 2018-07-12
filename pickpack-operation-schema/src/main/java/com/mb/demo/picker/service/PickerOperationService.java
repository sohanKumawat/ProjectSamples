package com.mb.demo.picker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.node.ProductNodeStoreEntity;
import com.mb.demo.entity.common.picker.PickerProductStatusEntity;
import com.mb.demo.picker.processor.PickerOperationStatusProcessor;
import com.mb.demo.service.PickerProductStatusService;

@Service
public class PickerOperationService {

	@Autowired
	PickerProductStatusService pickerProductStatusService;
	@Autowired
	PickerOperationStatusProcessor pickerOperationProcessor;

	public ProductNodeStoreEntity updateProductNodeStore(ProductNodeStoreEntity productNodeStore, String scannerCode) {
		return pickerOperationProcessor.updateProductNodeStore(productNodeStore, scannerCode);
	}

	public List<ProductNodeStoreEntity> findNodeProductStore(long hubId, long teamId, long productId, String sheet,
			OperationType pickerType) {

		return pickerOperationProcessor.findNodeProductStore(hubId, teamId, productId, sheet, pickerType);
	}

	public List<ProductNodeStoreEntity> findNodeProductStore(long hubId, long teamId, long productId, String sheet) {
		return pickerOperationProcessor.findNodeProductStore(hubId, teamId, productId, sheet);
	}

	public List<PickerProductStatusEntity> findPickerProductStatus(long hubId, long teamId, String sheet,
			OperationType pickerType, String createdOn) {
		return pickerProductStatusService.findPickerProductStatus(hubId, teamId, sheet, pickerType, createdOn);
	}

	public PickerProductStatusEntity updatePickerProductStatus(PickerProductStatusEntity ppStatusEntity) {
		return pickerProductStatusService.add(ppStatusEntity);
	}

}
