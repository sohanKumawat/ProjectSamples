package com.demo.slk.application.esshopifybacthprocesing.batch.writter.impl;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.DataItemWrite;
import com.demo.slk.application.esshopifybacthprocesing.batch.writter.DataItemWritter;
import com.demo.slk.application.esshopifybacthprocesing.es.service.ClientInventoryHerarichyService;

@StepScope
@Component(value = "picollectionDataWritter")
public class PICollectionItemWritterImpl<ClientInventoryHerarichy> implements DataItemWritter<DataItemWrite> {
	@Autowired
	ClientInventoryHerarichyService inventoryHerarichyService;

	@SuppressWarnings("unchecked")
	@Override
	public void write(List<? extends DataItemWrite> items) throws Exception {
		System.out.println("Inside the PICollectionItemWritterImpl");
		for (ClientInventoryHerarichy item : (List<ClientInventoryHerarichy>) items) {
			inventoryHerarichyService.save(item);
		}
	}
}
