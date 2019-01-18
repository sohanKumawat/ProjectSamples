package com.mb.demo.beans;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.mb.demo.constants.PickPackConstants.DataType;

import lombok.Data;

@Data
public class Attributes implements Serializable {
	private static final long serialVersionUID = -1410564303890327105L;

	private String title;
	@NotBlank
	private DataType data_type;// string integer,float,object;
	
	@NotBlank
	private String key;
	
	private Object value;

}
