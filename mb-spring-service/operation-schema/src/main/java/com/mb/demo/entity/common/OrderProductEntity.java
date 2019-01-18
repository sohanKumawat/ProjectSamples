package com.mb.demo.entity.common;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "order_product")
@lombok.Builder
@AllArgsConstructor
public class OrderProductEntity extends BaseProductAttributeEntity implements Serializable {

	private static final long serialVersionUID = -5133713769433904284L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long productId;
	private long orderId;
	private long customerId;
	private double discount_amt;
	private int quantity;
}