package com.mb.demo.entity.fa;

import java.io.Serializable;
import java.util.List;

import com.mb.demo.beans.BaseBean;
import com.mb.demo.entity.sa.SAProductPickerBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FAOrderProductPickerBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = -4641173177414489127L;
	private long id;
	private String orderId;
	private String orderSequenceNumber;
	private String hubId;
	private String teamId;
	private String sheet;
	private List<SAProductPickerBean> productPickerAttribute;

}
