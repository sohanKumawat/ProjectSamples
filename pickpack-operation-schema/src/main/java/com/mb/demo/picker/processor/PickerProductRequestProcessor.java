package com.mb.demo.picker.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.redis.beans.OrderProduct;
import com.mb.demo.redis.beans.PickerProductLocationBean;
import com.mb.demo.redis.processor.TeamOrderAndProductService;
import com.mb.demo.redis.processor.processor;

@processor
public class PickerProductRequestProcessor {

	/*
	 * @Autowired PickerOrderDataService pickerOrderService;
	 */
	@Autowired
	TeamOrderAndProductService teamOrderAndProductService;

	@Autowired
	PickerProductNodeMapper pickerProductNodeLocationMapper;

	public List<PickerProductLocationBean> processProductRequest(OperationType pickerType, long hubId, long teamId,
			String nodeId, String clusterId, String sheet) {

		List<PickerProductLocationBean> pickerProductBean = null;
		List<OrderProduct> pickerProducts = null;
		switch (pickerType) {
		case SAPICKER:
			pickerProducts = saPickerRequestProcess(hubId, teamId, nodeId, clusterId, sheet);

			pickerProductBean = pickerProductNodeLocationMapper.pickerProductWithStoreLocation(pickerProducts,
					Long.parseLong(nodeId));

			break;

		case FAPICKER:
			pickerProducts = faPickerRequestProcess(hubId, teamId, nodeId, clusterId, sheet);
			pickerProductBean = pickerProductNodeLocationMapper.pickerProductWithStoreLocation(pickerProducts,
					Long.parseLong(nodeId));
			break;
		default:
		}
		return pickerProductBean;
	}

	public List<OrderProduct> saPickerRequestProcess(long hubId, long teamId, String nodeId, String clusterId,
			String sheet) {
		if (null == clusterId && null != sheet) {
			return teamOrderAndProductService.getTeamProducts(teamId, hubId, sheet);
		} else if (null == clusterId && sheet == null) {
			return teamOrderAndProductService.getTeamProducts(teamId, hubId);
		} else if (null == sheet && null != clusterId) {
			return teamOrderAndProductService.getTeamProducts(teamId, hubId, Long.parseLong(clusterId));
		}
		return teamOrderAndProductService.getTeamProducts(teamId, hubId, sheet, Long.parseLong(clusterId));

	}

	public void mergerPickerProductWithStatus() {

	}

	public List<OrderProduct> faPickerRequestProcess(long hubId, long teamId, String nodeId, String clusterId,
			String sheet) {
		return null;
	}

}
