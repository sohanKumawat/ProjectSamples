package com.mb.demo.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.demo.entity.common.ProductEntity;

@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductEntity, Long> {
	//public ProductEntity findByIdAndHubId(int quantity, long id, long hubId);

	public ProductEntity findByIdAndHubId(long id, long hubId);

	public List<ProductEntity> findByHubId(long hubId);
}
