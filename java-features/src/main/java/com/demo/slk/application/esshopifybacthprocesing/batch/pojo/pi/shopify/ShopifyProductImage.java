package com.demo.slk.application.esshopifybacthprocesing.batch.pojo.pi.shopify;

import java.util.List;

import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.Image;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ShopifyProductImage extends Image {
	private static final long serialVersionUID = 1L;
	@JsonProperty(value="variant_ids")
	private List<Long> variantIds;
}
