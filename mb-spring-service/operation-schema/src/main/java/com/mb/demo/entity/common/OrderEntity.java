package com.mb.demo.entity.common;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "orders")
@lombok.Builder
public class OrderEntity implements Serializable {

	private static final long serialVersionUID = -5133713769433904284L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long customerId;
	private long clusterId;
	private long hubId;
	private long towerId;
	private long societyId;

}
