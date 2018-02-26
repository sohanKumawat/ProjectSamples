package com.demo.slk.application.esshopifybacthprocesing.batch.processor;

import com.demo.slk.application.esshopifybacthprocesing.batch.processor.impl.ShopifyDataProcessor;

public class PIDataProcessorFactory {
	@SuppressWarnings("rawtypes")
	public static PIDataProcessor getPIDataProcessor(String platform) {

		switch (platform) {
		case "shopify":
			return new ShopifyDataProcessor();
		}
		return null;

	}

}
