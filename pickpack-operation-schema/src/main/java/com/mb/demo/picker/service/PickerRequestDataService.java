package com.mb.demo.picker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.picker.processor.PickerOrderRequestProcessor;
import com.mb.demo.picker.processor.PickerProductRequestProcessor;
import com.mb.demo.redis.beans.HubTeamOrderEntity;
import com.mb.demo.redis.beans.PickerProductLocationBean;

@Service
public class PickerRequestDataService {

	@Autowired
	PickerOrderRequestProcessor pickerOrderRequest;

	@Autowired
	PickerProductRequestProcessor pickerProductRequest;

	public HubTeamOrderEntity getPickerTeamOrders(OperationType pickerType, long hubId, long teamId, String clusterId,
			String nodeId, String sheetId) {
		return pickerOrderRequest.processOrderRequest(pickerType, hubId, teamId, nodeId, clusterId, sheetId);
	}

	public List<PickerProductLocationBean> getPickerTeamProducts(OperationType pickerType, long hubId, long teamId,
			String clusterId, String nodeId, String sheetId) {
		return pickerProductRequest.processProductRequest(pickerType, hubId, teamId, nodeId, clusterId, sheetId);

	}
}
