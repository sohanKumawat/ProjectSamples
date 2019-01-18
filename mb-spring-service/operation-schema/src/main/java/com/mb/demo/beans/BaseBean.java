/*
 * @author Sushant
 * Copyright milkbasket.com
 */
package com.mb.demo.beans;

import java.io.Serializable;

import javax.validation.constraints.Null;

import lombok.Data;

/**
 * The Class BaseBean.
 *
 * @author Sushant
 * @version $Id: $Id
 */
@Data
public class BaseBean implements Serializable {

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
