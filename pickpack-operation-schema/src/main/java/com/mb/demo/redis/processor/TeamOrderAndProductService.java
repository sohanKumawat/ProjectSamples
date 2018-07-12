package com.mb.demo.redis.processor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.mb.demo.redis.beans.CustomerOrder;
import com.mb.demo.redis.beans.OrderProduct;
import com.mb.demo.redis.beans.HubTeamOrderEntity;
import com.mb.demo.redis.service.HubTeamOrderService;

@processor
public class TeamOrderAndProductService implements OrderProcessor {

	@Autowired
	HubTeamOrderService hubTeamOrderService;

	public HubTeamOrderEntity getTeamOrders(long teamId, long hubId) {
		return hubTeamOrderService.getById("#" + hubId + "#" + teamId);
	}

	public HubTeamOrderEntity getTeamOrders(long teamId, long hubId, String sheet) {
		return getTeamOrders(getTeamOrders(teamId, hubId), sheet);
	}

	public List<OrderProduct> getTeamProducts(long teamId, long hubId, String sheet) {
		HubTeamOrderEntity teamOrder = getTeamOrders(teamId, hubId);
		teamOrder = getTeamOrders(teamOrder, sheet);

		return getOrdersDistinctProducts(getOrderProducts(teamOrder.getOrders()));
	}

	public List<OrderProduct> getTeamProducts(long teamId, long hubId) {
		HubTeamOrderEntity teamOrder = getTeamOrders(teamId, hubId);
		return getOrdersDistinctProducts(getOrderProducts(teamOrder.getOrders()));
	}

	public HubTeamOrderEntity getTeamOrders(long teamId, long hubId, String sheet, long clusterId) {
		HubTeamOrderEntity teamOrder = getTeamOrders(teamId, hubId, clusterId);
		teamOrder = getTeamOrders(teamOrder, sheet);
		return teamOrder;
	}

	public List<OrderProduct> getTeamProducts(long teamId, long hubId, String sheet, long clusterId) {
		HubTeamOrderEntity teamOrder = getTeamOrders(teamId, hubId, clusterId);
		teamOrder = getTeamOrders(teamOrder, sheet);
		return getOrdersDistinctProducts(getOrderProducts(teamOrder.getOrders()));
	}

	public List<OrderProduct> getTeamProducts(long teamId, long hubId, long clusterId) {
		HubTeamOrderEntity pickerTeamOrderProduct = getTeamOrders(teamId, hubId, clusterId);
		return getOrdersDistinctProducts(getOrderProducts(pickerTeamOrderProduct.getOrders()));
	}

	private HubTeamOrderEntity getTeamOrders(HubTeamOrderEntity teamOrder, String sheet) {
		teamOrder.getOrders().stream().forEach(order -> {
			List<OrderProduct> products = order.getProducts().stream()
					.filter(product -> sheet.equals(product.getSheet())).collect(Collectors.toList());
			order.setProducts(products);
		});
		return teamOrder;
	}

	public HubTeamOrderEntity getTeamOrders(long teamId, long hubId, long clusterId) {
		HubTeamOrderEntity teamOrder = getTeamOrders(teamId, hubId);
		List<CustomerOrder> orders = teamOrder.getOrders().stream().filter(order -> clusterId == order.getClusterId())
				.collect(Collectors.toList());

		teamOrder.setOrders(orders);
		return teamOrder;
	}

	public List<OrderProduct> getOrderProducts(List<CustomerOrder> orders) {

		List<OrderProduct> orderProducts = new ArrayList<>();
		for (int i = 0; null != orders && i < orders.size(); i++) {
			orderProducts.addAll(orders.get(i).getProducts());
		}
		return orderProducts;
	}

	private List<OrderProduct> getOrdersDistinctProducts(List<OrderProduct> products) {
		Map<Long, Integer> productMap = products.stream().collect(
				Collectors.groupingBy(OrderProduct::getProductId, Collectors.summingInt(OrderProduct::getQuantity)));

		Set<OrderProduct> productSet = new HashSet<>();
		for (int k = 0; null != products && k < products.size(); k++) {
			if (!productSet.contains(products.get(k))) {
				OrderProduct op = products.get(k);
				op.setQuantity(productMap.get(op.getProductId()));
				productSet.add(op);
			}
		}
		List<OrderProduct> distinctProducts = new ArrayList<OrderProduct>(productSet);
		return distinctProducts;
	}

}
