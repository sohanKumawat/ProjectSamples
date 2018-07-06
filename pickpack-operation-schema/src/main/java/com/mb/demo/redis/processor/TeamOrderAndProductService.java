package com.mb.demo.redis.processor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.mb.demo.redis.beans.CustomerOrder;
import com.mb.demo.redis.beans.CustomerOrderProducts;
import com.mb.demo.redis.beans.HubTeamOrderEntity;
import com.mb.demo.redis.service.HubTeamOrderService;

@processor
public class TeamOrderAndProductService implements OrderProcessor {

	@Autowired
	HubTeamOrderService hubTeamOrderService;

	public HubTeamOrderEntity getTeamOrder(long teamId, long hubId) {
		return hubTeamOrderService.getById("#" + hubId + "#" + teamId);
	}

	public HubTeamOrderEntity getTeamOrderBySheet(long teamId, long hubId, String sheet) {
		HubTeamOrderEntity teamOrder = getTeamOrder(teamId, hubId);
		teamOrder.getOrders().stream().forEach(order -> {
			List<CustomerOrderProducts> products = order.getProducts().stream()
					.filter(product -> sheet.equals(product.getSheet())).collect(Collectors.toList());
			order.setProducts(products);
		});
		return teamOrder;
	}

	private HubTeamOrderEntity getTeamOrderBySheet(HubTeamOrderEntity teamOrder, String sheet) {

		teamOrder.getOrders().stream().forEach(order -> {
			List<CustomerOrderProducts> products = order.getProducts().stream()
					.filter(product -> sheet.equals(product.getSheet())).collect(Collectors.toList());
			order.setProducts(products);
		});
		return teamOrder;
	}

	public List<CustomerOrderProducts> getTeamProductsBySheet(long teamId, long hubId, String sheet) {
		HubTeamOrderEntity teamOrder = getTeamOrder(teamId, hubId);
		teamOrder = getTeamOrderBySheet(teamOrder, sheet);

		return getOrdersDistinctProducts(getOrderProducts(teamOrder.getOrders()));
	}

	public List<CustomerOrderProducts> getTeamProducts(long teamId, long hubId) {
		HubTeamOrderEntity teamOrder = getTeamOrder(teamId, hubId);
		return getOrdersDistinctProducts(getOrderProducts(teamOrder.getOrders()));
	}

	public HubTeamOrderEntity getTeamOrderBySheetAndClusterId(long teamId, long hubId, String sheet, long clusterId) {
		HubTeamOrderEntity teamOrder = getTeamOrderByClusterId(teamId, hubId, clusterId);
		teamOrder = getTeamOrderBySheet(teamOrder, sheet);
		return teamOrder;
	}

	public List<CustomerOrderProducts> getTeamProductBySheetAndClusterId(long teamId, long hubId, String sheet,
			long clusterId) {
		HubTeamOrderEntity teamOrder = getTeamOrderByClusterId(teamId, hubId, clusterId);
		teamOrder = getTeamOrderBySheet(teamOrder, sheet);
		return getOrdersDistinctProducts(getOrderProducts(teamOrder.getOrders()));
	}

	public List<CustomerOrderProducts> getTeamProductByClusterId(long teamId, long hubId, long clusterId) {
		HubTeamOrderEntity pickerTeamOrderProduct = getTeamOrderByClusterId(teamId, hubId, clusterId);
		return getOrdersDistinctProducts(getOrderProducts(pickerTeamOrderProduct.getOrders()));
	}

	public HubTeamOrderEntity getTeamOrderByClusterId(long teamId, long hubId, long clusterId) {
		HubTeamOrderEntity teamOrder = getTeamOrder(teamId, hubId);
		List<CustomerOrder> orders = teamOrder.getOrders().stream().filter(order -> clusterId == order.getClusterId())
				.collect(Collectors.toList());

		teamOrder.setOrders(orders);
		return teamOrder;
	}

	public List<CustomerOrderProducts> getOrderProducts(List<CustomerOrder> orders) {

		List<CustomerOrderProducts> orderProducts = new ArrayList<>();
		for (int i = 0; null != orders && i < orders.size(); i++) {
			orderProducts.addAll(orders.get(i).getProducts());
		}
		return orderProducts;
	}

	private List<CustomerOrderProducts> getOrdersDistinctProducts(List<CustomerOrderProducts> products) {
		Map<Long, Integer> productMap = products.stream().collect(Collectors.groupingBy(
				CustomerOrderProducts::getProductId, Collectors.summingInt(CustomerOrderProducts::getQuantity)));

		Set<CustomerOrderProducts> productSet = new HashSet<>();
		for (int k = 0; null != products && k < products.size(); k++) {
			if (!productSet.contains(products.get(k))) {
				CustomerOrderProducts op = products.get(k);
				op.setQuantity(productMap.get(op.getProductId()));
				productSet.add(op);
			}
		}
		List<CustomerOrderProducts> distinctProducts = new ArrayList<CustomerOrderProducts>(productSet);
		return distinctProducts;
	}

}
