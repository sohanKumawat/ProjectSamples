package com.mb.demo.redis.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mb.demo.repository.order.CustomerOrderRepository;
import com.mb.demo.repository.order.OrderProductMappingRepository;
import com.mb.demo.repository.order.OrderProductRepository;
import com.mb.demo.repository.product.ProductInventoryRepository;

@Component
public class OrderRepositoryFactory {

	@Autowired
	private CustomerOrderRepository orderRepository;

	@Autowired
	private OrderProductMappingRepository OrderProductMapping;
	@Autowired
	private OrderProductRepository OrderProduct;
	
	@Autowired
	ProductInventoryRepository productRepository;

	public CustomerOrderRepository getOrderRepository() {
		return orderRepository;
	}

	public OrderProductMappingRepository getOrderProductMapping() {
		return OrderProductMapping;
	}

	public OrderProductRepository getOrderProductRepository() {
		return OrderProduct;
	}
	
	public ProductInventoryRepository getProductRepository() {
		return productRepository;
	}

}
