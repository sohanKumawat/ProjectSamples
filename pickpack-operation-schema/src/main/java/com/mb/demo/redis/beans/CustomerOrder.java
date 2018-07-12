package com.mb.demo.redis.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrder {
	private long orderId;
	private long customerId;
	private long clusterId;
	private long hubId;
	private long towerId;
	private long societyId;
	private List<OrderProduct> products;

	public void addProduct(OrderProduct product) {
		if (CollectionUtils.isEmpty(products))
			products = new ArrayList<>();
		products.add(product);
	}

	public static CustomerOrder newInstance() {
		return new CustomerOrder();
	}

}
