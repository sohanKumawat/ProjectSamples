package com.mb.demo.entity.common.asset;

import java.io.Serializable;

import com.mb.demo.entity.common.BaseOperationBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AssetStatusEntity extends BaseOperationBean implements Serializable {

	private static final long serialVersionUID = -212278481835456325L;
	private String assestId;

}
