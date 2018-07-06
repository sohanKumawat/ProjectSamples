package com.mb.demo.entity.common.process;

import java.io.Serializable;

import com.mb.demo.beans.BaseProductAttribute;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductProcessingAttribute extends BaseProductAttribute implements Serializable {

	private static final long serialVersionUID = 5908635441886070484L;

	private int quantity;
	private int sample;
	private int offer;

}
