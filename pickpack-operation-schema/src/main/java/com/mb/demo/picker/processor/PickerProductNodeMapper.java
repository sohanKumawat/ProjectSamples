package com.mb.demo.picker.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mb.demo.redis.beans.CustomerOrderProducts;
import com.mb.demo.redis.beans.PickerProductLocationBean;
import com.mb.demo.redis.beans.ProductLocationBean;
import com.mb.demo.redis.beans.RedisNodeItemMetaDataEntity;
import com.mb.demo.redis.processor.processor;
import com.mb.demo.redis.service.picker.RedisNodeStorageService;
import com.mb.demo.utility.JsonUtility;

@processor
public class PickerProductNodeMapper {

	@Autowired
	RedisNodeStorageService redisNodeService;

	private List<RedisNodeItemMetaDataEntity> findProductNodeByNodeId(long nodeId) {
		return redisNodeService.findProductNodeByNodeId(nodeId);
	}

	public List<PickerProductLocationBean> pickerProductWithStoreLocation(List<CustomerOrderProducts> teamProducts,
			long nodeId) {

		List<RedisNodeItemMetaDataEntity> productNodes = findProductNodeByNodeId(nodeId);

		System.out.println("teamProducts json Value " + JsonUtility.toJson(teamProducts));
		System.out.println("productNodes json Value " + JsonUtility.toJson(productNodes));
		List<PickerProductLocationBean> pickerProductList = new ArrayList<>();
		for (int i = 0; null != teamProducts && i < teamProducts.size(); i++) {

			boolean isBreak = false;
			for (int j = 0; null != productNodes && j < productNodes.size(); j++) {

				System.out.println("productNodes id " + productNodes.get(i).getProductId());
				for (int k = 0; null != productNodes.get(j).getNodeItems()
						&& k < productNodes.get(j).getNodeItems().size(); k++) {
					if (productNodes.get(j).getNodeItems().get(k) != null && null != productNodes.get(j).getNodeItems()
							&& teamProducts.get(i).getProductId() == productNodes.get(j).getNodeItems().get(k)
									.getProductId()) {
						System.out.println("p ids metched");
						pickerProductList.add(generateProductLocationBean(teamProducts.get(i),
								productNodes.get(j).getNodeItems().get(k)));
						isBreak = true;
						break;
					}
				}
				if (isBreak)
					break;
			}
		}
		return pickerProductList;
	}

	public PickerProductLocationBean generateProductLocationBean(CustomerOrderProducts orderProduct,
			RedisNodeItemMetaDataEntity nodeLocation) {
		System.out.println("Inside the generateProductLocationBean");
		// CustomerOrderProducts orderproduct = orderProduct;
		ProductLocationBean productLocation = ProductLocationBean.builder().hubId(nodeLocation.getHubId())
				.locationArea(nodeLocation.getNodeArea()).locationId(nodeLocation.getNodeId())
				.locationName(nodeLocation.getName()).locationScannerCode(nodeLocation.getScannerCode())
				.locationTitle(nodeLocation.getTitle()).locationTrackerNumber(nodeLocation.getTrackerNumber())
				.productId(nodeLocation.getProductId()).build();
		PickerProductLocationBean pickerProductLocation = PickerProductLocationBean.builder().orderproduct(orderProduct)
				.productLocation(productLocation).build();
		return pickerProductLocation;
	}
}
