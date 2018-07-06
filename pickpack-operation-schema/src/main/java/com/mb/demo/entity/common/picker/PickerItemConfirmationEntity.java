package com.mb.demo.entity.common.picker;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mb.demo.constants.PickPackConstants.ActionStatus;
import com.mb.demo.constants.PickPackConstants.ItemType;
import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.BaseOperationEntity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/*Useful for fa and sa picker*/
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "picker_item_confirmation")
@ApiModel(description = "Picker item confirmation request data pojo ")
public class PickerItemConfirmationEntity extends BaseOperationEntity implements Serializable {
	private static final long serialVersionUID = 7591571918805807034L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private long ItemPickerStatusMappingId;// not null for sa but its null for fa.
	private OperationType pickerType;
	private long itemId;
	private ItemType itemType;
	private long parentId;
	private ItemType parentType;//product,order
	private ActionStatus status;

}
