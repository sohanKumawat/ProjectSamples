package com.demo.slk.application.esshopifybacthprocesing.batch.reader;

import java.util.List;

import com.demo.slk.application.esshopifybacthprocesing.RestAPIExchange;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.DataItemRead;

public interface DataReader<T> {
	@SuppressWarnings("hiding")
	public <T extends DataItemRead> List<T> dataReader(String botId, String platform, RestAPIExchange apiExchange)
			throws Exception;

}
