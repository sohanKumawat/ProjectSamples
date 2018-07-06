package com.mb.demo.redis.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mb.demo.redis.rowmapper.OrderProductMapper;
import com.mb.demo.redis.rowmapper.OrderProductMapper.OrderProductData;

@Repository
@Transactional
public class OrderDataRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<OrderProductData> getOrderByClusterId(List<Integer> clusterIds, long hubId) {
		List<String> cIds = new ArrayList<>();
		clusterIds.forEach(val -> cIds.add(val.toString()));
		String sql = "select ord.id,ord.hub_id,ord.cluster_id,ord.customer_id,ord.society_id,ord.tower_id,opm.product_id,opm.quantity,"
				+ "op.category_id,op.size,op.price,op.sheet,op.packing_type,op.scanner_code,op.image,"
				+ "op.name,op.type,op.subcategory_id,op.description from orders ord inner join order_product "
				+ "op on ord.id =op.order_id inner join order_product_mapping opm on op.order_id=opm.order_id "
				+ "and op.product_id=opm.product_id and ord.hub_id=" + hubId + " and ord.cluster_id in ("
				+ String.join(",", cIds) + ")";

		List<OrderProductData> orderProductData = jdbcTemplate.query(sql, new OrderProductMapper());

		return orderProductData;
	}

}
