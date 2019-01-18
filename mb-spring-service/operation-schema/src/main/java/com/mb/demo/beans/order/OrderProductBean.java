package com.mb.demo.beans.order;

import java.io.Serializable;

import com.mb.demo.beans.BaseProductAttribute;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(description = "Order product request pojo ")
public class OrderProductBean extends BaseProductAttribute implements Serializable {

	private static final long serialVersionUID = -5002439968503856249L;
	private int quantity;

}
