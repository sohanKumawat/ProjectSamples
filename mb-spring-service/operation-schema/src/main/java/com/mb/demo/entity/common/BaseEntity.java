package com.mb.demo.entity.common;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 7111344873483109021L;

		/** The created on. */
		private String createdOn;

		/** The created by. */
		private Long createdBy;

		/** The modified on. */
		private String modifiedOn;

		/** The modified by. */
		private Long modifiedBy;
}
