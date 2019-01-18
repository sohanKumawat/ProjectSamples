package com.mb.demo.picker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.picker.PickerProductStatusEntity;
import com.mb.demo.picker.processor.PickerOrderRequestProcessor;
import com.mb.demo.picker.processor.PickerProductRequestProcessor;
import com.mb.demo.redis.beans.PickerOrderProductLocationBean;
import com.mb.demo.redis.beans.PickerProductLocationBean;
import com.mb.demo.utility.DateUtility;

@Service
public class PickerRequestDataService {

	@Autowired
	PickerOrderRequestProcessor pickerOrderRequest;

	@Autowired
	PickerProductRequestProcessor pickerProductRequest;

	@Autowired
	PickerOperationService pickerOperationService;

	public List<PickerOrderProductLocationBean> getPickerTeamOrders(OperationType pickerType, long hubId, long teamId,
			String clusterId, String nodeId, String sheetId) {
		List<PickerOrderProductLocationBean> teamOrders = pickerOrderRequest.processOrderRequest(pickerType, hubId,
				teamId, nodeId, clusterId, sheetId);
		if (null != teamOrders && teamOrders.size() > 0) {
			List<PickerProductStatusEntity> productStatus = getPickerProductStatus(hubId, teamId, sheetId, pickerType);
			for (int i = 0; null != teamOrders && i < teamOrders.size(); i++) {
				mergeProductStatus(teamOrders.get(i).getPickerProductLocationBean(), productStatus);
			}
		}

		return teamOrders;
	}

	public List<PickerProductLocationBean> getPickerTeamProducts(OperationType pickerType, long hubId, long teamId,
			String clusterId, String nodeId, String sheetId) {

		List<PickerProductLocationBean> pickerProductBean = pickerProductRequest.processProductRequest(pickerType,
				hubId, teamId, nodeId, clusterId, sheetId);
		List<PickerProductStatusEntity> pickerProductStatus = getPickerProductStatus(hubId, teamId, sheetId,
				pickerType);
		if (null != pickerProductStatus && pickerProductStatus.size() > 0) {
			mergeProductStatus(pickerProductBean, pickerProductStatus);
		}

		return pickerProductBean;

	}

	public List<PickerProductStatusEntity> getPickerProductStatus(long hubId, long teamId, String sheetId,
			OperationType pickerType) {
		List<PickerProductStatusEntity> pickerProductStatus = pickerOperationService.findPickerProductStatus(hubId, teamId,
				sheetId, pickerType, DateUtility.getCurrentLocalDate("yyyy-MM-dd"));
		return pickerProductStatus;
	}

	public void mergeProductStatus(List<PickerProductLocationBean> pickerProductBean,
			List<PickerProductStatusEntity> productStatus) {

		for (int i = 0; null != pickerProductBean && i < pickerProductBean.size(); i++) {
			for (int j = 0; null != productStatus && j < productStatus.size(); j++) {
				if (null != pickerProductBean.get(i).getOrderproduct() && pickerProductBean.get(i).getOrderproduct()
						.getProductId() == productStatus.get(j).getProductId()) {
					pickerProductBean.get(i).setPickerProductStatus(productStatus.get(j));
				}
			}
		}

	}
}
