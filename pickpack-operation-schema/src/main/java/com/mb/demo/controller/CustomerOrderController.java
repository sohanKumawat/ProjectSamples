package com.mb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.demo.beans.order.OrderProductUpdateBean;
import com.mb.demo.service.CustomerOrderService;

import io.swagger.annotations.Api;

/*
 * This controller work on customer specific
 * We need to get Customer info from file like customerId,hubId,ClustrerId,SocietyId,TowerId
 * 
 * */
@RestController
@RequestMapping("/v1/customer/")
@Api(value = "customer order controller", description = "Operations pertaining to products in Online Store")
public class CustomerOrderController implements BasePickerController {
	@Autowired
	CustomerOrderService customerOrderService;

	@PostMapping("/order")
	public void order(@RequestBody OrderProductUpdateBean orderProductBean) {
		customerOrderService.order(orderProductBean);
	}

	@GetMapping("/order")
	public void findOrder() {
		customerOrderService.findOrder();
	}

	@GetMapping("/order/all") // current date orders
	public void findAllOrder() {

	}

	@GetMapping("/order/{startDate}/{endDate}")
	public void getAllOrder(@PathVariable String startDate, @PathVariable String endDate) {

	}
}
