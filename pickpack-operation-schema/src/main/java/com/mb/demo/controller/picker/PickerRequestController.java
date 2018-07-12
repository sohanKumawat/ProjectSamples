package com.mb.demo.controller.picker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.controller.BasePickerController;
import com.mb.demo.picker.service.PickerRequestDataService;
import com.mb.demo.redis.beans.PickerOrderProductLocationBean;
import com.mb.demo.redis.beans.PickerProductLocationBean;
import com.mb.demo.service.OrderDataService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/picker/order")
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class PickerRequestController implements BasePickerController {

	@Autowired
	OrderDataService service;
	@Autowired
	PickerRequestDataService pickerRequestService;

	/*
	 * @GetMapping("/add") public ResponseEntity<String> add(@RequestBody
	 * OrderAssetItemStoreEntity entity) { service.add(entity); return new
	 * ResponseEntity<>("Added successFulle", HttpStatus.OK); }
	 * 
	 * @GetMapping("/{Id}") public void findById(@PathVariable String id) {
	 * service.getById(Long.parseLong(id)); }
	 */

	@GetMapping("/{hubId}/{teamId}/{nodeId}/{sheet}")
	public List<PickerProductLocationBean> fetchProducts(@PathVariable long hubId, @PathVariable long teamId,
			@PathVariable String nodeId, @PathVariable String sheet) {
		log.debug("Input parameters hubId - {}, teamId - {},nodeId - {},sheet - {},", hubId, teamId, nodeId, sheet);
		return pickerRequestService.getPickerTeamProducts(OperationType.SAPICKER, hubId, teamId, null, nodeId, sheet);
	}

	@GetMapping("/{hubId}/{teamId}/{clusterId}/{nodeId}/{sheet}")
	public List<PickerProductLocationBean> fetchProducts(@PathVariable long hubId, @PathVariable long teamId,
			@PathVariable String clusterId, @PathVariable String nodeId, @PathVariable String sheet) {
		log.debug("Input parameters hubId - {}, teamId - {},nodeId - {},sheet - {},", hubId, teamId, nodeId, sheet);
		return pickerRequestService.getPickerTeamProducts(OperationType.SAPICKER, hubId, teamId, clusterId, nodeId,
				sheet);
	}

	@GetMapping("/{hubId}/{teamId}/{sheet}")
	public List<PickerOrderProductLocationBean> fetchOrders(@PathVariable long hubId, @PathVariable long teamId,
			@PathVariable String sheet) {
		log.debug("Input parameters hubId - {}, teamId - {},nodeId - {},sheet - {},", hubId, teamId, null, sheet);
		return pickerRequestService.getPickerTeamOrders(OperationType.FAPICKER, hubId, teamId, null, null, sheet);
	}

	@GetMapping("/{hubId}/{teamId}/{clusterId}/{sheet}")
	public List<PickerOrderProductLocationBean> fetchOrders(@PathVariable long hubId, @PathVariable long teamId,
			@PathVariable String clusterId, @PathVariable String sheet) {
		log.debug("Input parameters hubId - {}, teamId - {},nodeId - {},sheet - {},", hubId, teamId, null, sheet);
		return pickerRequestService.getPickerTeamOrders(OperationType.FAPICKER, hubId, teamId, clusterId, null, sheet);
	}
}
