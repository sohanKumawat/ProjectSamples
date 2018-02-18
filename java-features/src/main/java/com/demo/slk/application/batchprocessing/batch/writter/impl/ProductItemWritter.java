package com.demo.slk.application.batchprocessing.batch.writter.impl;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.demo.slk.application.batchprocessing.batch.pojo.ProductPojo;
import com.demo.slk.application.batchprocessing.batch.writter.RecordItemWritter;

public class ProductItemWritter implements RecordItemWritter,ItemWriter<ProductPojo>{

	public void productUpdate(){
		
	}

	@Override
	public void write(List<? extends ProductPojo> items) throws Exception {
		
	}

}
