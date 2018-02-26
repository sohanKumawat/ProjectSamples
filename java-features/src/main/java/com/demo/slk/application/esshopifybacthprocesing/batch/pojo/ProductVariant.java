package com.demo.slk.application.esshopifybacthprocesing.batch.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProductVariant implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	private String title;
	private double price;
	private String option1;
	private String option2;
	private String option3;
	private int inventory_quantity;
}
