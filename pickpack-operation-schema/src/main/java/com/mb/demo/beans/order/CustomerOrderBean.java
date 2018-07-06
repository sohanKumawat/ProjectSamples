package com.mb.demo.beans.order;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "Customer order bean request pojo ")
public class CustomerOrderBean implements Serializable {
	private static final long serialVersionUID = 8538549979577758295L;
	private String orderId;
	/*
	 * We can get the customerId, clusterId,hubId,towerId and societyId from
	 * Customer profile which is store in session or redis or userProfile. we will
	 * these properties
	 */
	/*private String customerId;
	private String clusterId;
	private String hubId;
	private String towerId;
	private String societyId;*/
	private List<OrderProductBean> orderProduct;
}
