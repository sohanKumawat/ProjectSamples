package com.mb.demo.entity.common.process;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;

import lombok.Data;

@Data
public class OrderProcessingInventory implements Serializable {

	private static final long serialVersionUID = -5479034775729645622L;
	
	@Column(unique = true)
	private long orderId;
	private int orderSequnceNumber;
	private String customerId;
	private String sheet;
	private long clusterId;
	private long hubId;
	private long towerId;
	private long societyId;
	List<ProductProcessingAttribute> productProcessingAttribute;

}
