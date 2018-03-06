package com.demo.slk.application.esshopifybacthprocesing.batch.reader.impl.helper;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import com.demo.slk.application.esshopifybacthprocesing.PIClientMetaDataHelper;
import com.demo.slk.application.esshopifybacthprocesing.RestAPIExchange;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.pi.shopify.ShopifyProduct;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.Collection;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.PIClientMetaData;
import com.demo.slk.application.esshopifybacthprocesing.batch.reader.ProductDataReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShopifyProductDataReader<T> implements ProductDataReader<T> {

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
		List<ShopifyProduct> colleProducts = new ArrayList<>();
		for (int i = 0;; i++) {
			List<ShopifyProduct> products = productByRangeAndCollectionId(i * 100, (i + 1) * 100, collectionId);
			if (null == products)
				break;
			colleProducts.addAll(products);
		}
		return colleProducts;
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
			JSONArray products = jsonObject.getJSONArray("products");
			shopifyProducts = OBJECT_MAPPER.readValue(products.toString(), new TypeReference<List<ShopifyProduct>>() {
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
			JSONArray collection = jsonObject.getJSONArray("custom_collections");
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
