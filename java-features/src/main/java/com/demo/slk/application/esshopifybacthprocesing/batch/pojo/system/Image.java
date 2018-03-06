package com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title;
	private String type;
	private String src;
}
