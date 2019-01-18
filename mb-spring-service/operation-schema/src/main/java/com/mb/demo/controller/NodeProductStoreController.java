package com.mb.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.demo.beans.node.NodeProductStoreBean;
import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.node.ProductNodeStoreEntity;
import com.mb.demo.picker.service.PickerOperationService;
import com.mb.demo.service.ProductNodeStoreService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/node/product/store")
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class NodeProductStoreController implements BasePickerController {

	@Autowired
	ProductNodeStoreService service;

	@Autowired
	PickerOperationService pickerOperationService;

	@PutMapping("/")
	public ResponseEntity<String> update(@RequestBody ProductNodeStoreEntity entity) {
		service.add(entity);
		return new ResponseEntity<>("Added successFulle", HttpStatus.OK);
	}

	@PostMapping("/")
	public ProductNodeStoreEntity updateProductStore(@RequestBody NodeProductStoreBean nodeProductStoreBean) {
		ProductNodeStoreEntity productNodeStoreEntity = ProductNodeStoreEntity.newInstance();
		productNodeStoreEntity.setAvailableQuantity(nodeProductStoreBean.getProductQuantity());
		productNodeStoreEntity.setHubId(nodeProductStoreBean.getHubId());
		productNodeStoreEntity.setNodeArea(nodeProductStoreBean.getPickerType());
		productNodeStoreEntity.setProductId(nodeProductStoreBean.getProductId());
		productNodeStoreEntity.setSheet(nodeProductStoreBean.getSheet());
		productNodeStoreEntity.setTeamId(nodeProductStoreBean.getTeamId());
		productNodeStoreEntity.setTotalQuantity(nodeProductStoreBean.getProductQuantity());
		productNodeStoreEntity.setNodeScannerCode(nodeProductStoreBean.getNodeScannerCode());
		
	//	productNodeStoreEntity.setNodeTracker(nodeProductStoreBean.getNodeScannerCode());
		return pickerOperationService.updateProductNodeStore(productNodeStoreEntity,
				nodeProductStoreBean.getNodeScannerCode());
	}

	@GetMapping("/{hubId}/{teamId}/{sheet}/{nodeArea}")
	public List<ProductNodeStoreEntity> findNodeProducts(@PathVariable long hubId, @PathVariable long teamId,
			@PathVariable String sheet, @PathVariable OperationType nodeArea) {
		return service.findProducts(hubId, teamId, sheet, nodeArea);
	}
	/*
	 * @GetMapping("/{hubId}/{teamId}/{productId}/{nodeArea}") public void
	 * findNodeProducts(@PathVariable long hubId, @PathVariable long
	 * teamId, @PathVariable long productId,
	 * 
	 * @PathVariable OperationType nodeArea) { service.findProducts(productId,
	 * hubId, teamId, nodeArea); }
	 */

	@GetMapping("/{id}")
	public void findById(@PathVariable long id) {
		service.getById(id);
	}
}
