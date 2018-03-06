package com.demo.slk.application.esshopifybacthprocesing.batch.processor.impl.helper;

import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.pi.shopify.ShopifyCollection;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.DataItemWrite;
import com.demo.slk.application.esshopifybacthprocesing.batch.processor.PIDataProcessor;
import com.demo.slk.application.esshopifybacthprocesing.es.entity.ClientInventoryHerarichy;

public class ShopifyCollectionProcessor<R, W extends DataItemWrite>
		implements PIDataProcessor<R, DataItemWrite> {
	@Override
	public DataItemWrite process(R item) throws Exception {
		
		System.out.println("inside the ShopifyDataProcessor data processor");
		ShopifyCollection pItem=(ShopifyCollection)item;
		ClientInventoryHerarichy inventoryHerarichy = new ClientInventoryHerarichy();
		inventoryHerarichy.setBotId("1232");
		inventoryHerarichy.setChildId(String.valueOf(pItem.getId()));
		inventoryHerarichy.setParentId("-1");
		inventoryHerarichy.setTitle(pItem.getTitle());
		inventoryHerarichy.setImageUrl(pItem.getImage() != null ? pItem.getImage().getSrc() : "");
		inventoryHerarichy.setDescription(pItem.getTitle());
		inventoryHerarichy.setType(pItem.getTitle());
		inventoryHerarichy.setName(pItem.getTitle());
		return inventoryHerarichy;
	}

}
