package com.mb.demo.beans;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PickerProductBean extends BaseProductAttribute implements Serializable {

	private static final long serialVersionUID = -8252586603185025787L;
	private String shelfTrackerNumber;
	private String sheet;

}
