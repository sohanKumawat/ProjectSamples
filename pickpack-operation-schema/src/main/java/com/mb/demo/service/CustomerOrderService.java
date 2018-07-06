package com.mb.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mb.demo.beans.order.CustomerOrderBean;
import com.mb.demo.beans.order.OrderProductUpdateBean;
import com.mb.demo.repository.order.CustomerOrderManagementRepository;

@Service
public class CustomerOrderService {

	@Autowired
	CustomerProfileService customerService;

	@Autowired
	CustomerOrderManagementRepository customerOrderRepository;

	public CustomerOrderBean order(OrderProductUpdateBean orderProductBean) {
		switch (orderProductBean.getActionType()) {

		case CREATE:
			creatOrder(orderProductBean);
			break;
		case ADD:
			updateOrder(orderProductBean);
			break;
		case REMOVE:
			updateOrder(orderProductBean);
			break;
		case DELETE:
			updateOrder(orderProductBean);
			break;

		default:
			break;

		}
		customerOrderRepository.createOrder(orderProductBean);
		return findOrder();
	}

	public void creatOrder(OrderProductUpdateBean orderProductBean) {
		customerOrderRepository.createOrder(orderProductBean);
	}

	public CustomerOrderBean findOrder() {
		//long customerId = customerService.getCustomerId();
		return new CustomerOrderBean();
	}

	public List<CustomerOrderBean> getAllOrder() {// Today date
		return new ArrayList<CustomerOrderBean>();
	}

	public List<CustomerOrderBean> getAllOrder(String customerId, String startDate, @PathVariable String endDate) {

		return new ArrayList<CustomerOrderBean>();

	}

	public void updateOrder(long customerId, OrderProductUpdateBean orderProductBean) {
		customerOrderRepository.updateOrder(orderProductBean);
	}

	public void updateOrder(OrderProductUpdateBean orderProductBean) {
		updateOrder(customerService.getCustomerId(), orderProductBean);
	}

}
