package com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Collection extends DataItemRead implements Serializable {
	private String id;
    private String subCategoryName1;
    private String subCategoryName2;
}
