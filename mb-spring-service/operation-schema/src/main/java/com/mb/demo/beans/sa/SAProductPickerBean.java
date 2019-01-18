package com.mb.demo.beans.sa;

import java.io.Serializable;

import com.mb.demo.beans.ProductPickerAttributeBean;
import com.mb.demo.beans.ShelfProductTrackerBean;
import com.mb.demo.entity.common.BaseOperationEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SAProductPickerBean extends BaseOperationEntity implements Serializable {

	private static final long serialVersionUID = 3449863202988837198L;

	private ShelfProductTrackerBean shelfProductTracker;
	private ProductPickerAttributeBean productPickerAttribute;

}
