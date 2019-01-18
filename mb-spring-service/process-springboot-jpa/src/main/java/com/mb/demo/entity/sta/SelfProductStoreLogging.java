package com.mb.demo.entity.sta;

import java.io.Serializable;

import com.mb.demo.entity.common.shelf.ShelfProductStoreEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SelfProductStoreLogging extends ShelfProductStoreEntity implements Serializable {

	private static final long serialVersionUID = -5303252493338503188L;
	private String teamId;
}
