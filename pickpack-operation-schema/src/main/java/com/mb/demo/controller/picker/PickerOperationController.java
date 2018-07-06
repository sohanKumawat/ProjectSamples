package com.mb.demo.controller.picker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.demo.entity.common.picker.PickerProductStatusEntity;

@RestController
@RequestMapping("/picker/")
public class PickerOperationController {

	@PostMapping("/pick/status")
	public void savePickStatuc(@RequestBody PickerProductStatusEntity pickerProductStatus) {

	}

	@GetMapping("/pick/status")
	public void findPickStatuc() {

	}

	@PutMapping("/pick/status")
	public void updatePickStatuc(@RequestBody PickerProductStatusEntity pickerProductStatus) {

	}

}
