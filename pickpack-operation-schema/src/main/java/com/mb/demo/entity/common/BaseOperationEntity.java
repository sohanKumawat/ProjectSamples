package com.mb.demo.entity.common;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseOperationEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 4573862414934023671L;
	private long teamId;
	private long hubId;
	private String sheet;
	private long userId;

}
