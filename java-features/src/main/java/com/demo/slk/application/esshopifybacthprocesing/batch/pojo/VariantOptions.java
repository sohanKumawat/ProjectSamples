package com.demo.slk.application.esshopifybacthprocesing.batch.pojo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class VariantOptions implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private List<String> values;
}
