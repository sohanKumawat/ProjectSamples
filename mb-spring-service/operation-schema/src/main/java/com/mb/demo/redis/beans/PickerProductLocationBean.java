package com.mb.demo.redis.beans;

import java.io.Serializable;
import java.util.List;

import com.mb.demo.entity.common.picker.PickerProductStatusEntity;

import lombok.Data;
import lombok.experimental.Builder;

@SuppressWarnings("deprecation")
@Data
@Builder
public class PickerProductLocationBean implements Serializable {
	private static final long serialVersionUID = -5507081992547355828L;

	private OrderProduct orderproduct;
	private List<ProductLocationBean> productLocation;
	private PickerProductStatusEntity pickerProductStatus;

}
