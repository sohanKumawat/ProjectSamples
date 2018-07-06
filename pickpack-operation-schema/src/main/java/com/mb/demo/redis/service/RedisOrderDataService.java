package com.mb.demo.redis.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.redis.beans.CustomerOrder;
import com.mb.demo.redis.beans.CustomerOrderProducts;
import com.mb.demo.redis.beans.HubTeamOrderEntity;
import com.mb.demo.redis.repository.OrderDataRepository;
import com.mb.demo.redis.rowmapper.OrderProductMapper;
import com.mb.demo.redis.rowmapper.OrderProductMapper.OrderProductData;

@Service
public class RedisOrderDataService {
	@Autowired
	HubTeamOrderService hubTeamOrderService;

	@Autowired
	HubTeamClusterService hubTeamClusterService;
	@Autowired
	OrderDataRepository orderDataRepo;

	@Autowired
	OrderProductMapper orderProductMapper;

	public void processOrder() {
		Map<String, List<Integer>> hubteamCluster = hubTeamClusterData();

		for (Map.Entry<String, List<Integer>> keyVal : hubteamCluster.entrySet()) {
			String key = keyVal.getKey();
			List<Integer> val = keyVal.getValue();
			if (key != null && key.length() > 0) {
				List<OrderProductData> orderProducts = getOrderByClusterAndHubId(val, Long.valueOf(key.split("#")[1]));
				List<CustomerOrder> orders = processOrderByClusters(orderProducts);
				HubTeamOrderEntity hubTeamorder = HubTeamOrderEntity.builder()
						.id("#" + Long.valueOf(key.split("#")[1]) + "#" + Long.valueOf(key.split("#")[2]))
						.hubId(Long.valueOf(key.split("#")[1])).teamId(Long.valueOf(key.split("#")[2])).build();
				hubTeamorder.setOrders(orders);
				hubTeamOrderService.save(hubTeamorder);
			}
		}
	}

	public Map<String, List<Integer>> hubTeamClusterData() {
		Map<String, List<Integer>> hubteamCluster = hubTeamClusterService.hubTeamClusterData();
		return hubteamCluster;
	}

	public List<OrderProductData> getOrderByClusterAndHubId(List<Integer> clusterIds, long hubId) {
		List<OrderProductData> orderProductData = orderDataRepo.getOrderByClusterId(clusterIds, hubId);
		return orderProductData;
	}

	public List<CustomerOrder> processOrderByClusters(List<OrderProductData> orders) {

		Map<String, CustomerOrder> customerOrderMap = new HashMap<>();

		for (int i = 0; i < orders.size(); i++) {
			OrderProductData orderProduct = orders.get(i);
			String key = orderProduct.getHub_id() + orderProduct.getOrderId() + "";
			if (customerOrderMap.containsKey(key)) {
				addOrderProduct(orderProduct, customerOrderMap.get(key));
			} else {
				CustomerOrder customerOrder = CustomerOrder.newInstance();
				customerOrder.setOrderId(orderProduct.getOrderId());
				customerOrder.setClusterId(orderProduct.getClusterId());
				customerOrder.setCustomerId(orderProduct.getCustomerId());
				customerOrder.setSocietyId(orderProduct.getSocietyId());
				customerOrder.setTowerId(orderProduct.getTowerId());
				customerOrder.setHubId(orderProduct.getHub_id());
				addOrderProduct(orderProduct, customerOrder);
				customerOrderMap.put(key, customerOrder);
			}
		}
		return new ArrayList<CustomerOrder>(customerOrderMap.values());

	}

	public void addOrderProduct(OrderProductData orderProduct, CustomerOrder customerOrder) {
		CustomerOrderProducts product = CustomerOrderProducts.builder().productId(orderProduct.getProductId())
				.hubId(orderProduct.getHub_id()).sheet(orderProduct.getSheet()).name(orderProduct.getName())
				.size(orderProduct.getSize()).scannerCode(orderProduct.getScannerCode())
				.categoryId(orderProduct.getCategoryId()).subcategoryId(orderProduct.getSubCategoryId())
				.image(orderProduct.getImage()).type(orderProduct.getType()).description(orderProduct.getDescription())
				.packingType(orderProduct.getPackingType()).quantity(orderProduct.getQuantity())
				.price(orderProduct.getPrice()).build();
		customerOrder.addProduct(product);
	}
}
