package com.mb.demo.entity.common.picker;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.mb.demo.constants.PickPackConstants.ItemType;
import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.BaseOperationBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/*Use full for fa and sa picker*/
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "picker_item_confirmation")
public class PickerItemConfirmationEntity extends BaseOperationBean implements Serializable {
	private static final long serialVersionUID = 7591571918805807034L;
	private long id;
	private long productPickerStatusMappingId;// not null for sa but its null for fa.
	private OperationType pickerType;
	private long itemId;
	private ItemType itemType;
	private long parentId;
	private ItemType parentItemType;

}
