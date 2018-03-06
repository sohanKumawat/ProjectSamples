package com.demo.slk.application.esshopifybacthprocesing.batch.reader;

import com.demo.slk.application.esshopifybacthprocesing.batch.reader.impl.helper.ShopifyCollectionDataReader;
import com.demo.slk.application.esshopifybacthprocesing.batch.reader.impl.helper.ShopifyProductDataReader;

public class PIDataReaderFactory {

	@SuppressWarnings("rawtypes")
	public static DataReader getPIReader(String platform, String type) {

		switch (platform) {

		case "shopify":
			if ("product".equalsIgnoreCase(type))
				return new ShopifyProductDataReader();
			if ("collection".equalsIgnoreCase(type))
				return new ShopifyCollectionDataReader();
		}
		return null;

	}

}
