package com.demo.slk.application.esshopifybacthprocesing.batch.processor.impl.helper;

import java.util.ArrayList;
import java.util.List;

import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.pi.shopify.ShopifyProduct;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.pi.shopify.ShopifyProductImage;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.pi.shopify.ShopifyProductVariant;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.DataItemWrite;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.PIProductItemWrite;
import com.demo.slk.application.esshopifybacthprocesing.batch.processor.PIDataProcessor;
import com.demo.slk.application.esshopifybacthprocesing.es.entity.PIProductInventory;

public class ShopifyProductProcessor<R, W extends DataItemWrite> implements PIDataProcessor<R, PIProductItemWrite> {
	@Override
	public PIProductItemWrite process(R item) throws Exception {
		System.out.println("inside the ShopifyDataProcessor data processor");
		ShopifyProduct sItem = (ShopifyProduct) item;

		List<PIProductInventory> piProductInventory = new ArrayList<>();
		PIProductInventory inventoryProduct = new PIProductInventory();
		inventoryProduct.setBotId("1232");
		//inventoryProduct.setCategory(collection.getTitle());
		inventoryProduct.setProductId(String.valueOf(sItem.getId()));
		inventoryProduct.setPublishedAt(sItem.getPublishedAt());
		inventoryProduct.setUpdatedAt(sItem.getUpdatedAt());
		inventoryProduct.setSubCategory1(sItem.getProducType());
		if (sItem.getVariants() != null)
			for (ShopifyProductVariant variant : sItem.getVariants()) {
				inventoryProduct.setAvailableQuantity(variant.getInventory_quantity());
				inventoryProduct.setFilter1Value(variant.getOption1());
				inventoryProduct.setFilter2Value(variant.getOption2());
				inventoryProduct.setFilter3Value(variant.getOption3());
				inventoryProduct.setPrice(variant.getPrice());
				inventoryProduct.setStatus(variant.getInventory_quantity() > 0 ? "yes" : "no");
				if (null != sItem.getImages() && sItem.getImages().size() > 0
						&& sItem.getImages().get(0).getSrc() != null) {
					inventoryProduct.setImageUrl(sItem.getImages().get(0).getSrc());
					for (ShopifyProductImage image : sItem.getImages()) {
						for (Long vId : image.getVariantIds()) {
							if (vId == Long.parseLong(variant.getId() != null ? variant.getId() : "0")) {
								inventoryProduct.setImageUrl(image.getSrc());
								break;
							}
						}
					}
				}
				for (int i = 0; i < sItem.getOptions().size(); i++) {
					if (i == 0)
						inventoryProduct.setFilter1Key(sItem.getOptions().get(i).getName());
					if (i == 1)
						inventoryProduct.setFilter2Key(sItem.getOptions().get(i).getName());
					if (i == 2)
						inventoryProduct.setFilter3Key(sItem.getOptions().get(i).getName());
				}
				piProductInventory.add(inventoryProduct);
			}
		else {
			piProductInventory.add(inventoryProduct);
		}
		/*platformDataWriter.productWrite(piProductInventory);
		platformDataWriter.inventoryHerarichyWrite(inventoryHerarichy);*/

		return new PIProductItemWrite();
	}

}
