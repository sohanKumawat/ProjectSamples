package com.mb.demo.redis.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedisProductPickerBean extends CustomerOrderProducts implements Serializable {

	private static final long serialVersionUID = 8623632191628663153L;

	private long aisleId;
	private String aisleName;
	private long shelfId;
	private String shelfName;
	private String shelfNumber;
	private String shelfTrackerName;

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		RedisProductPickerBean product = (RedisProductPickerBean) obj;
		return (product.getProductId() == this.getProductId() && product.getProductId() == this.getProductId());
	}

	@Override
	public int hashCode() {
		return (int) this.getProductId();
	}
	
	public static RedisProductPickerBean newInstance() {
		return new RedisProductPickerBean();
	}
}
