package com.mb.demo.entity.common;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.mb.demo.beans.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BaseOperationBean extends BaseBean implements Serializable {
	private static final long serialVersionUID = 4573862414934023671L;
	@NotBlank
	private String teamId;
	@NotBlank
	private String hubId;
	@NotBlank
	private String sheet;

}
