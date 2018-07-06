package com.mb.demo.redis.rowmapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mb.demo.redis.rowmapper.OrderProductMapper.OrderProductData;

import lombok.Data;

@Component
public class OrderProductMapper implements RowMapper<OrderProductData> {

	@Override
	public OrderProductData mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderProductData orderProductData = new OrderProductData();
		orderProductData.setOrderId(rs.getLong("hub_id"));
		orderProductData.setHub_id(rs.getLong("hub_id"));
		orderProductData.setClusterId(rs.getLong("cluster_id"));
		orderProductData.setCustomerId(rs.getLong("customer_id"));
		orderProductData.setSocietyId(rs.getLong("society_id"));
		orderProductData.setTowerId(rs.getLong("tower_id"));
		orderProductData.setProductId(rs.getLong("product_id"));
		orderProductData.setCategoryId(rs.getLong("category_id"));
		orderProductData.setSubCategoryId(rs.getLong("subcategory_id"));
		orderProductData.setQuantity(rs.getInt("quantity"));
		orderProductData.setSize(rs.getString("size"));
		orderProductData.setSheet(rs.getString("sheet"));
		orderProductData.setPackingType(rs.getString("packing_type"));
		orderProductData.setScannerCode(rs.getString("scanner_code"));
		orderProductData.setType(rs.getString("image"));
		orderProductData.setPrice(rs.getDouble("price"));
		orderProductData.setName(rs.getString("name"));
		orderProductData.setType(rs.getString("type"));
		orderProductData.setDescription(rs.getString("description"));
		return orderProductData;
	}

	@Data
	public class OrderProductData implements Serializable {

		private static final long serialVersionUID = 7865576426900572731L;
		private long orderId;
		private long hub_id;
		private long clusterId;
		private long customerId;
		private long societyId;
		private long towerId;
		private long productId;
		private int quantity;
		private long categoryId;
		private String size;
		private String sheet;
		private String packingType;
		private String scannerCode;
		private String image;
		private double price;
		private String name;
		private String type;
		private long subCategoryId;
		private String description;

	}

}
