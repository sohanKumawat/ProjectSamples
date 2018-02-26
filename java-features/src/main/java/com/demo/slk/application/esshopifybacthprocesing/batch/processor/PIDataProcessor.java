package com.demo.slk.application.esshopifybacthprocesing.batch.processor;

import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.DataItemWrite;

public interface PIDataProcessor<R, W extends DataItemWrite> {
	public  DataItemWrite process(R item) throws Exception ;
}
