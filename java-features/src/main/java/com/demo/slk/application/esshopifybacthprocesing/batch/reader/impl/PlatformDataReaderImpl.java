package com.demo.slk.application.esshopifybacthprocesing.batch.reader.impl;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.demo.slk.application.esshopifybacthprocesing.RestAPIExchange;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.DataItemRead;
import com.demo.slk.application.esshopifybacthprocesing.batch.reader.PIDataReaderFactory;
import com.demo.slk.application.esshopifybacthprocesing.batch.reader.PlatformDataReader;

@StepScope
@Component(value="platformDataReader")
public class PlatformDataReaderImpl<T> implements ItemReader<T> {

	@Value("#{jobParameters['platform']}")
	private String platform="shopify";
	@Value("#{jobParameters['readFlag']}")
	private String readFlag="yes";
	@Value("#{jobParameters['botId']}")
	private String botId="212";
	
	@Autowired
	RestAPIExchange apiExchange;

	@SuppressWarnings({ "unchecked", "rawtypes", "null" })
	@Override
	public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		List<DataItemRead> productItems = null;
		if ("yes".equalsIgnoreCase(readFlag)) {
			System.out.println("Inside the data read");
			productItems = ((PlatformDataReader) PIDataReaderFactory.getPIReader(platform)).dataReader(botId,
					platform,apiExchange);
			readFlag = "no";
		}
		if (null == productItems && productItems.size() <= 0)
			return null;
		return (T) productItems.remove(productItems.size() - 1);
	}
}
