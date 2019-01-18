package com.mb.demo.redis.beans;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PickerOrderProductLocationBean {
	private long orderId;
	private long customerId;
	private long clusterId;
	private long hubId;
	private long towerId;
	private long societyId;
	private List<PickerProductLocationBean> pickerProductLocationBean;
}
