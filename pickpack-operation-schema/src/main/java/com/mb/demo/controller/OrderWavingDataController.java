package com.mb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.demo.entity.common.metaData.AssetMedaDataEntity;
import com.mb.demo.redis.processor.RedisOrderDataStoreProcess;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/waving/order")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class OrderWavingDataController implements BasePickerController {

	@Autowired
	RedisOrderDataStoreProcess orderDataProcessor;

	@GetMapping("/team/{teamId}/{hubId}")
	public ResponseEntity<String> add(@RequestBody AssetMedaDataEntity entity) {
		//orderDataProcessor.orderDataProcessor();
		return new ResponseEntity<>("procced successFulle", HttpStatus.OK);
	}
}
