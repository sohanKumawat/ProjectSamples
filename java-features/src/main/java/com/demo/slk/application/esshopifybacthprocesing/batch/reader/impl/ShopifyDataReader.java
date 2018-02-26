package com.demo.slk.application.esshopifybacthprocesing.batch.reader.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import com.demo.slk.application.esshopifybacthprocesing.PIClientMetaDataHelper;
import com.demo.slk.application.esshopifybacthprocesing.RestAPIExchange;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.Collection;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.PIClientMetaData;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.ShopifyProduct;
import com.demo.slk.application.esshopifybacthprocesing.batch.reader.PlatformDataReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShopifyDataReader<T> implements PlatformDataReader<T> {
	
	RestAPIExchange apiExchange;
	PIClientMetaData piClientMetaData;

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	@SuppressWarnings("unchecked")
	@Override
	public ShopifyProduct productById() {
		return new ShopifyProduct();
	}

	public void productListById() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopifyProduct> productByCollectionId(String collectionId) throws Exception {
		boolean pflag = true;
		int limit = 100;
		List<ShopifyProduct> productItem = new ArrayList<>();
		while (pflag) {
			List<ShopifyProduct> products = productByRangeAndCollectionId(productItem.size(), limit, collectionId);
			if (null == products) {
				pflag = false;
				break;
			}
			productItem.addAll(products);
		}
		return productItem;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopifyProduct> productByRangeAndCollectionId(int start, int end, String collectionid)
			throws Exception {
		ResponseEntity<String> collectionResponse = apiExchange
				.exchange("/products.json?collection_id=" + collectionid);
		String response = collectionResponse.getBody();
		List<ShopifyProduct> shopifyProducts = null;
		if (null != response) {
			JSONObject jsonObject = new JSONObject(response);
			JSONObject collection = jsonObject.getJSONObject("custom_collections");
			shopifyProducts = OBJECT_MAPPER.readValue(collection.toString(), new TypeReference<List<Collection>>() {
			});
		}
		return shopifyProducts;
	}

	public List<Collection> fetchCollections() throws Exception {
		ResponseEntity<String> collectionResponse = apiExchange
				.exchange("/custom_collections.json?fields=title,id,image");
		String response = collectionResponse.getBody();
		List<Collection> collections = null;
		if (null != response) {
			JSONObject jsonObject = new JSONObject(response);
			JSONObject collection = jsonObject.getJSONObject("custom_collections");
			collections = OBJECT_MAPPER.readValue(collection.toString(), new TypeReference<List<Collection>>() {
			});
		}
		return collections;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopifyProduct> dataReader(String botId, String platform, RestAPIExchange apiExchange)
			throws Exception {
		System.out.println("Inside the data dataReader");
		this.apiExchange = apiExchange;
		piClientMetaData = PIClientMetaDataHelper.getClientMetaData(apiExchange);
		List<ShopifyProduct> productItems = new ArrayList<>();
		List<Collection> collections = fetchCollections();
		if (null != collections)
			for (Collection collection : collections) {
				List<ShopifyProduct> items = productByCollectionId(collection.getId());
				productItems.addAll(items);
			}
		return productItems;
	}
}
