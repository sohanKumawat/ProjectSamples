package com.demo.slk.application.esshopifybacthprocesing.batch.processor;

import com.demo.slk.application.esshopifybacthprocesing.batch.processor.impl.helper.ShopifyCollectionProcessor;
import com.demo.slk.application.esshopifybacthprocesing.batch.processor.impl.helper.ShopifyProductProcessor;

public class PIDataProcessorFactory {
	@SuppressWarnings("rawtypes")
	public static PIDataProcessor getPIDataProcessor(String platform, String type) {

		switch (platform) {
		case "shopify":
			if ("product".equalsIgnoreCase(type))
				return new ShopifyProductProcessor();
			if ("collection".equalsIgnoreCase(type))
				return new ShopifyCollectionProcessor();
		}
		return null;

	}

}
