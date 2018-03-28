package com.demo.slk.application.esshopifybacthprocesing.batch.pojo.pi.shopify;

import java.io.Serializable;

import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.VariantOptions;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ShopifyProductVariant extends VariantOptions implements Serializable{
	private static final long serialVersionUID = 1L;
	private String title;
	private double price;
	private String option1;
	private String option2;
	private String option3;
	private int inventory_quantity;
}
