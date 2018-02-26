package com.demo.slk.application.esshopifybacthprocesing.batch.pojo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ShopifyProduct extends DataItemRead implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	private String title;
	private String vendor;
	@JsonProperty(value="product_type")
	private String producType;
	@JsonProperty(value="createda_at")
	private String createdAt;
	@JsonProperty(value="updated_at")
	private String updatedAt;
	@JsonProperty(value="published_at")
	private String publishedAt;
	private List<String> tags;
	private List<ProductVariant> variants;
	private List<VariantOptions> options;
	private List<ProductImage> images;
}
