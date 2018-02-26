package com.demo.slk.application.esshopifybacthprocesing.batch.reader;

import com.demo.slk.application.esshopifybacthprocesing.batch.reader.impl.ShopifyDataReader;

public class PIDataReaderFactory {

	@SuppressWarnings("rawtypes")
	public static PlatformDataReader getPIReader(String platform) {

		switch (platform) {
		case "shopify":
			return new ShopifyDataReader();
		}
		return null;

	}

}
