package com.mb.demo.redis.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.util.CollectionUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash(value= "pickerorderprocessor",timeToLive=36000)//this object automatic destroy after 10hours
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HubTeamOrderEntity implements Serializable {
	private static final long serialVersionUID = 8699549305526782095L;

	private String id;
	private long hubId;
	private long teamId;
	private List<CustomerOrder> orders;

	@SuppressWarnings("unused")
	private void addOrder(CustomerOrder order) {
		if (CollectionUtils.isEmpty(orders))
			orders = new ArrayList<>();
		orders.add(order);
	}

}
