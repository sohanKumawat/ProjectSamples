package com.demo.slk.application.batchprocessing.batch.reader.impl;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.demo.slk.application.batchprocessing.batch.pojo.ProductPojo;
import com.demo.slk.application.batchprocessing.batch.reader.ProductItemReader;

public class ProductItemReaderImpl implements ProductItemReader{

	@Override
	public void productById() {
		
	}

	@Override
	public void productByCollectionId(String collectionId) {
		
	}

	@Override
	public void productByRangeAndCollectionId(int start, int end, String collectionid) {
		
	}

	@Override
	public ProductPojo read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		return new ProductPojo();
	}

}
