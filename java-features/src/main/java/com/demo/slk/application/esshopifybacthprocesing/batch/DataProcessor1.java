package com.demo.slk.application.esshopifybacthprocesing.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.pi.shopify.ShopifyProduct;
import com.demo.slk.application.esshopifybacthprocesing.batch.pojo.system.Collection;

@Component
public class DataProcessor1 {

	@Autowired
	PlatformDataWritter1 platformDataWriter;
	public void process(ShopifyProduct item,Collection collection) {/*
		List<PIProductInventory> piProductInventory = new ArrayList<>();
		ClientInventoryHerarichy inventoryHerarichy=new ClientInventoryHerarichy();
		inventoryHerarichy.setBotId("1232");
		inventoryHerarichy.setChildId(String.valueOf(item.getId()));
		inventoryHerarichy.setParentId("-1");
		inventoryHerarichy.setTitle(collection.getTitle());
		inventoryHerarichy.setUrl(collection.getImage()!=null?collection.getImage().getSrc():"");
		inventoryHerarichy.setDescription(collection.getTitle());
		inventoryHerarichy.setType(item.getProducType());
		inventoryHerarichy.setName(collection.getTitle());
		
		PIProductInventory inventoryProduct = new PIProductInventory();
		inventoryProduct.setBotId("1232");
		inventoryProduct.setCategory(collection.getTitle());
		inventoryProduct.setProductId(String.valueOf(item.getId()));
		inventoryProduct.setPublishedAt(item.getPublishedAt());
		inventoryProduct.setUpdatedAt(item.getUpdatedAt());
		inventoryProduct.setSubCategory1(item.getProducType());
		if (item.getVariants() != null)
			for (ShopifyProductVariant variant : item.getVariants()) {
				inventoryProduct.setAvailableQuantity(variant.getInventory_quantity());
				inventoryProduct.setFilter1Value(variant.getOption1());
				inventoryProduct.setFilter2Value(variant.getOption2());
				inventoryProduct.setFilter3Value(variant.getOption3());
				inventoryProduct.setPrice(variant.getPrice());
				inventoryProduct.setStatus(variant.getInventory_quantity() > 0 ? "yes" : "no");
				if (null != item.getImages() && item.getImages().size() > 0
						&& item.getImages().get(0).getSrc() != null) {
					inventoryProduct.setImageUrl(item.getImages().get(0).getSrc());
					for (ShopifyProductImage image : item.getImages()) {
						for (Long vId : image.getVariantIds()) {
							if (vId == Long.parseLong(variant.getId()!=null?variant.getId():"0")) {
								inventoryProduct.setImageUrl(image.getSrc());
								break;
							}
						}
					}
				}
				for (int i=0;i<item.getOptions().size();i++) {
					if(i==0) inventoryProduct.setFilter1Key(item.getOptions().get(i).getName());
					if(i==1) inventoryProduct.setFilter2Key(item.getOptions().get(i).getName());
					if(i==2) inventoryProduct.setFilter3Key(item.getOptions().get(i).getName());
				}
				piProductInventory.add(inventoryProduct);
			}
		else {
			piProductInventory.add(inventoryProduct);
		}
		platformDataWriter.productWrite(piProductInventory);
		platformDataWriter.inventoryHerarichyWrite(inventoryHerarichy);
	*/}
}
