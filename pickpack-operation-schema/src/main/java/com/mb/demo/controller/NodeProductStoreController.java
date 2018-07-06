package com.mb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.demo.entity.common.node.ProductNodeStoreEntity;
import com.mb.demo.service.ProductNodeStoreService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/v1/shelf/product/store")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class NodeProductStoreController implements BasePickerController {

	@Autowired
	ProductNodeStoreService service;

	@GetMapping("/add")
	public ResponseEntity<String> add(@RequestBody ProductNodeStoreEntity entity) {
		service.add(entity);
		return new ResponseEntity<>("Added successFulle", HttpStatus.OK);
	}

	@GetMapping("/{Id}")
	public void findById(@PathVariable String id) {
		service.getById(Long.parseLong(id));
	}
}

