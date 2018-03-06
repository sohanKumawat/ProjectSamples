package com.demo.slk.application.esshopifybacthprocesing.batch.writter.impl;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.DataItemWrite;
import com.demo.slk.application.esshopifybacthprocesing.batch.writter.DataItemWritter;
import com.demo.slk.application.esshopifybacthprocesing.es.repository.ProductInvetoryRepository;
import com.demo.slk.application.esshopifybacthprocesing.es.service.ProductInventoryService;

@StepScope
@Component(value = "piproductDataWritter")
public class PIProductItemWritterImpl<PIProductInventory> implements DataItemWritter<DataItemWrite> {
	@Autowired
	ProductInventoryService productInventoryService;
	@Autowired
	ProductInvetoryRepository productInvetoryRepository;

	@SuppressWarnings("unchecked")
	@Override
	public void write(List<? extends DataItemWrite> items) throws Exception {
		System.out.println("Inside the PIProductItemWritterImpl");
		for (PIProductInventory item : (List<PIProductInventory>) items) {
			productInventoryService.save(item);
		}
	}
}
