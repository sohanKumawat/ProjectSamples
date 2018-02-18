package com.demo.slk.application.batchprocessing.batch.reader;

import org.springframework.batch.item.ItemReader;

import com.demo.slk.application.batchprocessing.batch.pojo.ProductPojo;

public interface ProductItemReader extends RecordItemReader, ItemReader<ProductPojo> {

	public void productById();

	public void productByCollectionId(String collectionId);

	public void productByRangeAndCollectionId(int start, int end, String collectionid);

}
