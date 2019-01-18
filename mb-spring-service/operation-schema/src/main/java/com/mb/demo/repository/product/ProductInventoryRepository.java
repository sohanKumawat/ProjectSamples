package com.mb.demo.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.demo.entity.common.ProductInventoryEntity;

@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductInventoryEntity, Long> {
	//public ProductEntity findByIdAndHubId(int quantity, long id, long hubId);

	public ProductInventoryEntity findByIdAndHubId(long id, long hubId);

	public List<ProductInventoryEntity> findByHubId(long hubId);
}
