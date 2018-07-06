package com.mb.demo.redis.beans;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Builder;

@SuppressWarnings("deprecation")
@Data
@Builder
public class PickerProductLocationBean implements Serializable {
	private static final long serialVersionUID = -5507081992547355828L;

	private CustomerOrderProducts orderproduct;
	private ProductLocationBean productLocation;

}
