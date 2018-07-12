package com.mb.demo.controller.picker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.demo.entity.common.node.ProductNodeStoreEntity;
import com.mb.demo.entity.common.picker.PickerProductStatusEntity;
import com.mb.demo.picker.service.PickerOperationService;
import com.mb.demo.utility.DateUtility;

@RestController
@RequestMapping("/v1/picker/")
public class PickerOperationController {

	@Autowired
	PickerOperationService pickerOperationService;

	@PostMapping("/status")
	public void savePickStatuc(@RequestBody PickerProductStatusEntity pickerProductStatus) {

	}

	@PostMapping("/product/accept")
	public PickerProductStatusEntity savePickerProductStatus(
			@RequestBody PickerProductStatusEntity pickerProductStatus) {
		pickerProductStatus.setCreatedOn(DateUtility.getCurrentLocalDate("yyyy-MM-dd"));
		return pickerOperationService.updatePickerProductStatus(pickerProductStatus);
	}

	@PutMapping("/product/accept")
	public PickerProductStatusEntity updatePickerProductStatus(
			@RequestBody PickerProductStatusEntity pickerProductStatus) {
		pickerProductStatus.setModifiedOn(DateUtility.getCurrentLocalDate("yyyy-mm-dd"));
		return pickerOperationService.updatePickerProductStatus(pickerProductStatus);

	}

	@GetMapping("/store/product/{hubId}/{teamId}/{sheet}/{productId}")
	public List<ProductNodeStoreEntity> getNodeProductStore(@PathVariable long hubId, @PathVariable long teamId,
			@PathVariable String sheet, @PathVariable long productId) {
		return pickerOperationService.findNodeProductStore(hubId, teamId, productId, sheet);
	}

}
