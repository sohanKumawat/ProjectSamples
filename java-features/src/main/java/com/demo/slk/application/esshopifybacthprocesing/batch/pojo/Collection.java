package com.demo.slk.application.esshopifybacthprocesing.batch.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Collection {
	private String id;
	private String title;
	private Image image;
    private String subCategoryName1;
    private String subCategoryName2;
}
