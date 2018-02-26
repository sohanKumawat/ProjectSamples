package com.demo.slk.application.esshopifybacthprocesing.batch.pojo;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PIDataItemWrite extends DataItemWrite {
	@Id
	private String id;
	private String platform;

}
