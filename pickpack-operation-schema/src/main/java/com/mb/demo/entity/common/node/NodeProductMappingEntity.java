package com.mb.demo.entity.common.node;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.mb.demo.entity.common.BaseEntity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "node_product_mapping")
@ApiModel(description = "Shelf product mapping request data pojo ")
public class NodeProductMappingEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -5592574650376486428L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private long hubId;
	@NotBlank
	private long productId;
	private long nodeId;
	// private OperationType area_type;
	private int priority = 1;
}
