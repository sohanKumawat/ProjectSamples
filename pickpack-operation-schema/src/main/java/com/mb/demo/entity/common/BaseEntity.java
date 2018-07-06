package com.mb.demo.entity.common;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Null;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 7111344873483109021L;

		/** The created on. */
		@Null
		private String createdOn;

		/** The created by. */
		@Null
		private Long createdBy;

		/** The modified on. */
		@Null
		private String modifiedOn;

		/** The modified by. */
		@Null
		private Long modifiedBy;
}
