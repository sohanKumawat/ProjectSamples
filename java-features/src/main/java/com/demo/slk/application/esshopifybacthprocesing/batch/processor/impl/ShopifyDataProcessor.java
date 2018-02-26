package com.demo.slk.application.esshopifybacthprocesing.batch.processor.impl;

import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.DataItemWrite;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.PIDataItemWrite;
import com.demo.slk.application.esshopifybacthprocesing.batch.processor.PIDataProcessor;

public class ShopifyDataProcessor<R, W extends DataItemWrite> implements PIDataProcessor<R, PIDataItemWrite> {
	@Override
	public PIDataItemWrite process(R item) throws Exception {
		System.out.println("inside the ShopifyDataProcessor data processor");
		return new PIDataItemWrite();
	}

}
