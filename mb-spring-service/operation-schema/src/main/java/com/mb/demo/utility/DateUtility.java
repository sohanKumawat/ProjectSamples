package com.mb.demo.utility;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class DateUtility {

	public static String getCurrentLocalDate(String pattern) {
		return dateFormat(pattern).format(LocalDate.now());
	}

	public static LocalDate getCurrentLocalDate() {
		return LocalDate.now();
	}

	public static String getCurrentLocalDate(String pattern, String zoneId) {
		return dateFormat(pattern).format(LocalDate.now(ZoneId.of(zoneId)));
	}

	public static DateTimeFormatter dateFormat(String pattern) {
		if (null == pattern)
			return DateTimeFormatter.ISO_LOCAL_DATE;
		return DateTimeFormatter.ofPattern(pattern);
	}

	public static void main(String srt[]) {
		@SuppressWarnings("unused")
		String date = getCurrentLocalDate(null);

		List<String> clusterIds = Arrays.asList("1", "2", "4");
		long hubId = 1;
		String sql = "select ord.id,ord.hub_id,ord.cluster_id,ord.customer_id,ord.society_id,ord.tower_id,opm.product_id,opm.quantity,"
				+ "op.category_id,op.size,op.price,op.sheet,op.packing_type,op.scanner_code,op.image,"
				+ "op.name,op.type,op.subcategory_id,op.description from orders ord inner join order_product "
				+ "op on ord.id =op.order_id inner join order_product_mapping opm on op.order_id=opm.order_id "
				+ "and op.product_id=opm.product_id and ord.hub_id=" + hubId + " and ord.cluster_id in ("
				+ String.join(",", clusterIds) + ")";

		System.out.println("*** sql ** " + sql);
	}
}
