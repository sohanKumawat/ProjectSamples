package com.mb.demo.entity.sa;

import java.io.Serializable;

import com.mb.demo.entity.common.BaseOperationBean;
import com.mb.demo.entity.common.shelf.ShelfProductTrackerBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SAProductPickerBean extends BaseOperationBean implements Serializable {

	private static final long serialVersionUID = 3449863202988837198L;

	private ShelfProductTrackerBean shelfProductTracker;
	private ProductPickerAttributeBean productPickerAttribute;

}
