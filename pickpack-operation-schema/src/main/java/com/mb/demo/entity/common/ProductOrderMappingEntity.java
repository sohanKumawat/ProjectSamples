package com.mb.demo.entity.common;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "order_product_mapping")
@EqualsAndHashCode(callSuper = false)
@lombok.Builder
public class ProductOrderMappingEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 5549366900301439464L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private long orderId;
	@NotBlank
	private long customerId;
	@NotBlank
	private long productId;
	@NotBlank
	private int quantity;
}
