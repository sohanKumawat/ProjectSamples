package com.mb.demo.picker.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.node.ProductNodeStoreEntity;
import com.mb.demo.redis.beans.CustomerOrder;
import com.mb.demo.redis.beans.HubTeamOrderEntity;
import com.mb.demo.redis.beans.OrderProduct;
import com.mb.demo.redis.beans.PickerOrderProductLocationBean;
import com.mb.demo.redis.beans.PickerProductLocationBean;
import com.mb.demo.redis.beans.ProductLocationBean;
import com.mb.demo.redis.processor.TeamOrderAndProductService;
import com.mb.demo.redis.processor.processor;
import com.mb.demo.service.ProductNodeStoreService;

@processor
public class PickerOrderRequestProcessor {

	@Autowired
	TeamOrderAndProductService teamOrderAndProductService;

	@Autowired
	PickerProductNodeMapper pickerProductNodeLocationMapper;

	@Autowired
	ProductNodeStoreService productNodeStoreService;

	public List<PickerOrderProductLocationBean> processOrderRequest(OperationType pickerType, long hubId, long teamId,
			String nodeId, String clusterId, String sheet) {
		List<PickerOrderProductLocationBean> teamOrders = null;
		switch (pickerType) {
		case SAPICKER:
			teamOrders = saPickerRequestProcess(hubId, teamId, nodeId, clusterId, sheet);
			break;

		case FAPICKER:
			teamOrders = faPickerRequestProcess(hubId, teamId, nodeId, clusterId, sheet);
			break;
		default:
		}
		return teamOrders;
	}

	public List<PickerOrderProductLocationBean> saPickerRequestProcess(long hubId, long teamId, String nodeId,
			String clusterId, String sheet) {

		return null;
	}

	public List<PickerOrderProductLocationBean> faPickerRequestProcess(long hubId, long teamId, String nodeId,
			String clusterId, String sheet) {
		List<ProductNodeStoreEntity> productStore = null;
		HubTeamOrderEntity teamOrder = null;
		if (null == clusterId) {
			teamOrder = teamOrderAndProductService.getTeamOrders(hubId, teamId, sheet);
			if (null != teamOrder)
				productStore = findTeamNodeProductStore(hubId, teamId, sheet, OperationType.FAPICKER);
		} else {
			teamOrder = teamOrderAndProductService.getTeamOrders(hubId, teamId, sheet, Long.parseLong(clusterId));
			if (null != teamOrder)
				productStore = findTeamNodeProductStore(hubId, teamId, sheet, OperationType.FAPICKER);
		}
		return convertToPickerOrder(teamOrder, productStore);

	}

	public List<ProductNodeStoreEntity> findTeamNodeProductStore(long hubId, long teamId, String sheet,
			OperationType nodeArea) {
		List<ProductNodeStoreEntity> productStore = productNodeStoreService.findProducts(hubId, teamId, sheet,
				nodeArea);
		return productStore;
	}

	public List<PickerOrderProductLocationBean> convertToPickerOrder(HubTeamOrderEntity teamOrder,
			List<ProductNodeStoreEntity> pNodestore) {
		List<PickerOrderProductLocationBean> pickerOrders = new ArrayList<>();
		for (int i = 0; null != teamOrder && null != teamOrder.getOrders() && i < teamOrder.getOrders().size(); i++) {

			CustomerOrder order = teamOrder.getOrders().get(i);
			List<PickerProductLocationBean> ppLocationBean = productLocationMapper(pNodestore, order.getProducts());
			PickerOrderProductLocationBean pickerOrder = PickerOrderProductLocationBean.builder()
					.hubId(order.getHubId()).clusterId(order.getClusterId()).customerId(order.getCustomerId())
					.orderId(order.getOrderId()).pickerProductLocationBean(ppLocationBean)
					.societyId(order.getSocietyId()).towerId(order.getTowerId()).build();
			pickerOrders.add(pickerOrder);
		}
		return pickerOrders;
	}

	public List<PickerProductLocationBean> productLocationMapper(List<ProductNodeStoreEntity> productStore,
			List<OrderProduct> products) {
		List<ProductLocationBean> productLocation = null;
		List<PickerProductLocationBean> pickerProductLocationBean = null;
		for (int i = 0; null != products && i < products.size(); i++) {
			if (null == pickerProductLocationBean)
				pickerProductLocationBean = new ArrayList<>();
			productLocation = null;
			for (int j = 0; null != productStore & j < productStore.size(); j++) {
				if (null != products.get(i) && productStore.get(j) != null
						&& products.get(i).getProductId() == productStore.get(j).getProductId()) {
					if (null == productLocation)
						productLocation = new ArrayList<>();

					ProductLocationBean pLocationBean = ProductLocationBean.builder()
							.hubId(productStore.get(j).getHubId()).locationArea(productStore.get(j).getNodeArea())
							.locationId(productStore.get(j).getNodeId())
							.locationScannerCode(productStore.get(j).getNodeScannerCode())
							.locationTrackerNumber(productStore.get(j).getNodeTracker())
							.productId(productStore.get(j).getProductId()).build();
					productLocation.add(pLocationBean);
				}
			}
			PickerProductLocationBean ppLocationBean = PickerProductLocationBean.builder().orderproduct(products.get(i))
					.build();
			if (null != productLocation) {
				ppLocationBean.setProductLocation(productLocation);
				pickerProductLocationBean.add(ppLocationBean);
			}
		}

		return pickerProductLocationBean;
	}

}
