package com.demo.slk.application.esshopifybacthprocesing.batch.reader.impl.helper;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import com.demo.slk.application.esshopifybacthprocesing.PIClientMetaDataHelper;
import com.demo.slk.application.esshopifybacthprocesing.RestAPIExchange;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.pi.shopify.ShopifyCollection;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.Collection;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.PIClientMetaData;
import com.demo.slk.application.esshopifybacthprocesing.batch.reader.CollectionDataReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShopifyCollectionDataReader<T> implements CollectionDataReader<T> {

	RestAPIExchange apiExchange;
	PIClientMetaData piClientMetaData;

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopifyCollection> dataReader(String botId, String platform, RestAPIExchange apiExchange)
			throws Exception {
		System.out.println("Inside the data dataReader");
		this.apiExchange = apiExchange;
		piClientMetaData = PIClientMetaDataHelper.getClientMetaData(apiExchange);
		List<ShopifyCollection> collections = allCollection();
		return collections;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ShopifyCollection collectionById(String collectionId) throws Exception {
		return new ShopifyCollection();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopifyCollection> fromToCollectionReader(int start, int end) throws Exception {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopifyCollection> allCollection() throws Exception {
		ResponseEntity<String> collectionResponse = apiExchange
				.exchange("/custom_collections.json?fields=title,id,image");
		String response = collectionResponse.getBody();
		List<ShopifyCollection> collections = null;
		if (null != response) {
			JSONObject jsonObject = new JSONObject(response);
			JSONArray collection = jsonObject.getJSONArray("custom_collections");
			collections = OBJECT_MAPPER.readValue(collection.toString(), new TypeReference<List<Collection>>() {
			});
		}
		return collections;
	}
}
