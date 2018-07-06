package com.mb.demo.picker.processor;

import org.springframework.beans.factory.annotation.Autowired;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.redis.beans.HubTeamOrderEntity;
import com.mb.demo.redis.processor.processor;

@processor
public class PickerOrderRequestProcessor {

	@Autowired
	PickerProductNodeMapper pickerProductNodeLocationMapper;

	public HubTeamOrderEntity processOrderRequest(OperationType pickerType, long hubId, long teamId, String nodeId,
			String clusterId, String sheet) {
		HubTeamOrderEntity teamOrders = null;
		switch (pickerType) {
		case SAPICKER:
			teamOrders = saPickerRequestProcess(hubId, teamId, nodeId, clusterId, sheet);
			break;

		case FAPICKER:
			teamOrders = faPickerRequestProcess(hubId, teamId, nodeId, clusterId, sheet);
			break;
		default:
		}
		return teamOrders;
	}

	public HubTeamOrderEntity saPickerRequestProcess(long hubId, long teamId, String nodeId, String clusterId,
			String sheet) {

		return null;
	}

	public HubTeamOrderEntity faPickerRequestProcess(long hubId, long teamId, String nodeId, String clusterId,
			String sheet) {
		return null;
	}

}
