package com.demo.slk.application.esshopifybacthprocesing.batch.pojo.pi.shopify;

import java.io.Serializable;

import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.Collection;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.Image;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ShopifyCollection extends Collection implements Serializable{
	private static final long serialVersionUID = 4119366619263238997L;
	private String title;
	private Image image;
}
