package com.mb.demo.entity.sta;

import java.io.Serializable;

import com.mb.demo.beans.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductSellsForcastingEntity extends BaseBean implements Serializable {
	private static final long serialVersionUID = 1314856133623362256L;
	private long id;
	private String productId;
	private String teamId;
	private String hubId;
	private long quantity;

}
