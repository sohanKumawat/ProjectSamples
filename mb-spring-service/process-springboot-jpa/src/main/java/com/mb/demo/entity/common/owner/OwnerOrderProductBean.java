package com.mb.demo.entity.common.owner;

import java.io.Serializable;
import java.util.List;

import com.mb.demo.entity.common.BaseOperationBean;
import com.mb.demo.entity.sa.ProductPickerAttributeBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OwnerOrderProductBean extends BaseOperationBean implements Serializable {

	private static final long serialVersionUID = 2987706196909990255L;

	private long id;
	private String orderId;
	private String customerId;
	private String orderSequenceNumber;
	private List<ProductPickerAttributeBean> productAttribute;

}
