package com.mb.demo.entity.common.asset;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mb.demo.constants.PickPackConstants.ActionStatus;
import com.mb.demo.entity.common.BaseOperationEntity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 * This entity we can in case of asset in use or its available for use. But i think its not required.
 * 
 * */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@ApiModel(description = "AssetStatus request pojo ")
public class AssetStatusEntity extends BaseOperationEntity implements Serializable {

	private static final long serialVersionUID = -212278481835456325L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private long assetId;
	private long orderId;
	private ActionStatus status;

}
