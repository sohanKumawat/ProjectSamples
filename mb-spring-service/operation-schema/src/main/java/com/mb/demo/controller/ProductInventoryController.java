package com.mb.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.demo.entity.common.ProductInventoryEntity;
import com.mb.demo.service.ProductInventoryService;

@RestController
@RequestMapping("/v1/metadata/product")
public class ProductInventoryController {

	@Autowired
	ProductInventoryService productInventoryService;

	@PostMapping("/add")
	public ProductInventoryEntity save(@RequestBody ProductInventoryEntity product) {
		return productInventoryService.save(product);
	}

	@PutMapping("/update/{id}")
	public ProductInventoryEntity update(@RequestBody ProductInventoryEntity product) {
		return productInventoryService.update(product);
	}

	@GetMapping("/find/{id}")
	public ProductInventoryEntity findById(@PathVariable String id) {
		return productInventoryService.findById(Long.parseLong(id));
	}

	@GetMapping("/find/{hubId}/{id}")
	public ProductInventoryEntity findByIdAndHubId(@PathVariable long hubId, @PathVariable long id) {
		return productInventoryService.findByIdAndHubId(id, hubId);
	}

	@GetMapping("/find/{hubId}")
	public List<ProductInventoryEntity> findByHubId(@PathVariable long hubId) {
		return productInventoryService.findByHubId(hubId);
	}

	@GetMapping("/find/all")
	public List<ProductInventoryEntity> findAll() {
		return productInventoryService.findAll();
	}

	/*
	 * @PutMapping("/update") // this might we can use with s3 update event or
	 * csv,exls file update event public List<ProductEntity> bulkUpdate(@RequestBody
	 * List<ProductEntity> product) {
	 * 
	 * }
	 */
}
