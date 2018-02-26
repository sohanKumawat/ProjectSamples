package com.demo.slk.application.esshopifybacthprocesing.batch;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.demo.slk.application.esshopifybacthprocesing.RestAPIExchange;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.Collection;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.ShopifyProduct;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PlatformDataReader1 {
	@Autowired
	RestAPIExchange apiExchange;
	@Autowired
	DataProcessor1 dataProcessor1;

	public List<ShopifyProduct> productByCollectionId(Collection collection) throws Exception {
		int limit = 100;
			List<ShopifyProduct> products = productByRangeAndCollectionId(0, limit, collection);
		return products;

	}

	public List<ShopifyProduct> productByRangeAndCollectionId(int start, int end, Collection collection)
			throws Exception {
		ResponseEntity<String> collectionResponse = apiExchange
				.exchange("/products.json?collection_id=" + collection.getId());
		String response = collectionResponse.getBody();
		List<ShopifyProduct> shopifyProducts = null;
		if (null != response) {
			JSONObject jsonObject = new JSONObject(response);
			JSONArray products = jsonObject.getJSONArray("products");
			shopifyProducts = OBJECT_MAPPER.readValue(products.toString(), new TypeReference<List<ShopifyProduct>>() {
			});
		}
		return shopifyProducts;
	}

	boolean read = false;
	List<ShopifyProduct> productItems;

	public void read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		productItems = new ArrayList<>();
		List<Collection> collections = fetchCollections();
		if (null != collections)
			for (Collection collection : collections) {
				List<ShopifyProduct> items = productByCollectionId(collection);
				for (ShopifyProduct shopifyProduct : items) {
					shopifyProduct.setProducType("Shirt");
					dataProcessor1.process(shopifyProduct, collection);
				}
			}
	}

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

	public List<Collection> fetchCollections() throws Exception {
		ResponseEntity<String> collectionResponse = apiExchange
				.exchange("/custom_collections.json?fields=title,id,image");
		String response = collectionResponse.getBody();
		List<Collection> collections = null;
		if (null != response) {
			JSONObject jsonObject = new JSONObject(response);
			JSONArray collection = jsonObject.getJSONArray("custom_collections");
			collections = OBJECT_MAPPER.readValue(collection.toString(), new TypeReference<List<Collection>>() {
			});
		}
		return collections;

	}
}
