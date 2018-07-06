package com.mb.demo.entity.common;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseOperationEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 4573862414934023671L;
	@NotBlank
	private long teamId;
	@NotBlank
	private long hubId;
	@NotBlank
	private String sheet;
	private long userId;

}
