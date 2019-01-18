package com.mb.demo.repository.order;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.mb.demo.beans.CustomerProfile;
import com.mb.demo.beans.order.CustomerOrderBean;
import com.mb.demo.beans.order.OrderProductUpdateBean;
import com.mb.demo.constants.PickPackConstants.ActionType;
import com.mb.demo.entity.common.OrderEntity;
import com.mb.demo.entity.common.OrderProductEntity;
import com.mb.demo.entity.common.ProductInventoryEntity;
import com.mb.demo.redis.factory.OrderRepositoryFactory;

@Repository
@Transactional(value = TxType.REQUIRED)
public class CustomerOrderManagementRepository {
	@Autowired
	public JdbcTemplate jdbcTemplate;
	@Autowired
	CustomerProfile customerProfile;

	@Autowired
	OrderRepositoryFactory orderFactory;

	public CustomerOrderBean createOrder(OrderProductUpdateBean orderProductBean) {
		ProductInventoryEntity productEntity = updateProductInventory(orderProductBean.getProductId(),
				customerProfile.getHubId(), orderProductBean.getActionType());

		if (null != productEntity) {
			OrderEntity orderEntity = OrderEntity.builder().societyId(customerProfile.getSocietyId())
					.hubId(customerProfile.getHubId()).clusterId(customerProfile.getClusterId())
					.towerId(customerProfile.getTowerId()).customerId(customerProfile.getCustomerId()).build();

			orderEntity = orderFactory.getOrderRepository().saveAndFlush(orderEntity);

			orderProductBean.setOrderId(orderEntity.getId());
			orderProductBean.setActionType(ActionType.ADD);
			updateOrder(orderProductBean);

			return getOrderById(orderEntity.getId());

		} else {
			return null;
		}
	}

	public CustomerOrderBean getOrderByCustomerId(long customerId) {
		return new CustomerOrderBean();
	}

	public CustomerOrderBean getOrderById(long orderId) {
		return new CustomerOrderBean();
	}

	public List<CustomerOrderBean> getAllOrder() {
		return new ArrayList<CustomerOrderBean>();
	}

	public List<CustomerOrderBean> getAllOrder(String startDate, @PathVariable String endDate) {

		return new ArrayList<CustomerOrderBean>();

	}

	public ProductInventoryEntity updateOrder(OrderProductUpdateBean orderProductBean) {
		ProductInventoryEntity productEntity = updateProductInventory(orderProductBean.getProductId(),
				customerProfile.getHubId(), orderProductBean.getActionType());
		if (null != productEntity) {
			if (orderProductBean.getActionType() == ActionType.ADD && orderProductBean.getProductId() == 1) {
				updateOrderProductMapping(orderProductBean);
				addOrderProduct(productEntity, orderProductBean.getOrderId());
				return productEntity;
			}
		} else {
			return null;
		}
		return productEntity;

	}

	public void updateOrderProductMapping(OrderProductUpdateBean orderProductBean) {

		/*
		 * ProductOrderMappingEntity productOrderMapping =
		 * ProductOrderMappingEntity.builder()
		 * .customerId(customerProfile.getCustomerId()).productId(orderProductBean.
		 * getProductId()) .quantity(orderProductBean.getQuantity()).build();
		 * 
		 * productOrderMapping.setOrderId(orderProductBean.getOrderId());
		 * 
		 * productOrderMapping =
		 * orderFactory.getOrderProductMapping().save(productOrderMapping);
		 */
	}

	public ProductInventoryEntity updateProductInventory(long productId, long hubId, ActionType operationType) {
		ProductInventoryEntity productEntity = getProductByIdAndHubId(productId, hubId);
		switch (operationType) {
		case REMOVE:
			productEntity.setQuantity(productEntity.getQuantity() + 1);
			break;

		case ADD:
			if (productEntity.getQuantity() > 0)
				productEntity.setQuantity(productEntity.getQuantity() - 1);
			else {
				return null;
			}
			break;
		default:
			break;

		}
		orderFactory.getProductRepository().saveAndFlush(productEntity);
		return productEntity;

	}

	public ProductInventoryEntity getProductByIdAndHubId(long productId, long hubId) {
		ProductInventoryEntity productEntity = orderFactory.getProductRepository().findByIdAndHubId(productId,
				customerProfile.getHubId());
		return productEntity;
	}

	public void addOrderProduct(ProductInventoryEntity productEntity, long orderId) {

		/*
		 * to do -> availability, type(procurment,mb) add to order_product table If
		 * there is no availability then show to message customer and enable request
		 * button
		 */
		OrderProductEntity orderProduct = OrderProductEntity.builder().productId(productEntity.getId()).orderId(orderId)
				.build();
		orderProduct.setImage(productEntity.getImage());
		orderProduct.setName(productEntity.getName());
		orderProduct.setSheet(productEntity.getSheet());
		orderProduct.setType(productEntity.getType());
		orderProduct.setSubcategoryId(productEntity.getSubcategoryId());
		orderProduct.setSize(productEntity.getSize());
		orderProduct.setPrice(productEntity.getPrice());
		orderProduct.setScannerCode(productEntity.getScannerCode());
		orderProduct.setPackingType(productEntity.getPackingType());
		orderFactory.getOrderProductRepository().save(orderProduct);

	}

}
