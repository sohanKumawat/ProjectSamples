package com.demo.slk.application.batchprocessing.batch.processor.impl;

import org.springframework.batch.item.ItemProcessor;

import com.demo.slk.application.batchprocessing.batch.pojo.ProductPojo;
import com.demo.slk.application.batchprocessing.batch.processor.RecordItemProcessor;

public class ProductItemProcessor implements RecordItemProcessor,ItemProcessor<ProductPojo, ProductPojo> {

	@Override
	public ProductPojo process(ProductPojo item) throws Exception {
		// TODO Auto-generated method stub
		return new ProductPojo();
	}

}
