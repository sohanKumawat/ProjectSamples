package com.demo.slk.application.esshopifybacthprocesing.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.slk.application.esshopifybacthprocesing.es.entity.ClientInventoryHerarichy;
import com.demo.slk.application.esshopifybacthprocesing.es.entity.PlProductInventory;
import com.demo.slk.application.esshopifybacthprocesing.es.service.ClientInventoryHerarichyService;
import com.demo.slk.application.esshopifybacthprocesing.es.service.FilterMappingService;
import com.demo.slk.application.esshopifybacthprocesing.es.service.ProductInventoryService;

@Component
public class PlatformDataWritter1 {
	@Autowired
	FilterMappingService filterMappingService;
	@Autowired
	ProductInventoryService productInventoryService;

	@Autowired
	ClientInventoryHerarichyService clientInventoryHerarichyService;

	public void productWrite(List<PlProductInventory> piProductInvList) {
		for (PlProductInventory piproduct : piProductInvList)
			productInventoryService.save(piproduct);
	}

	public void inventoryHerarichyWrite(ClientInventoryHerarichy clientInventoryHerarichy) {
		clientInventoryHerarichyService.save(clientInventoryHerarichy);
	}
}
