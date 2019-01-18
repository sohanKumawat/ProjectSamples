package com.mb.demo.beans.order;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mb.demo.constants.PickPackConstants.ActionType;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(description = "Order product update request pojo ")
public class OrderProductUpdateBean implements Serializable {

	private static final long serialVersionUID = 2549094049467088762L;
	/*
	 * update operation perform on today date only.
	 */
	private long orderId;
	@NotBlank
	private long productId;
	@NotBlank
	private int quantity;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	@NotBlank
	private ActionType actionType;

}
