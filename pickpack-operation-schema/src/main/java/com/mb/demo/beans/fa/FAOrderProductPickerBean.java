package com.mb.demo.beans.fa;

import java.io.Serializable;
import java.util.List;

import com.mb.demo.beans.BaseBean;
import com.mb.demo.beans.sa.SAProductPickerBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FAOrderProductPickerBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = -4641173177414489127L;
	private long id;
	private long orderId;
	private long orderSequenceNumber;
	private String hubId;
	private long teamId;
	private String sheet;
	private List<SAProductPickerBean> productPickerAttribute;

}
