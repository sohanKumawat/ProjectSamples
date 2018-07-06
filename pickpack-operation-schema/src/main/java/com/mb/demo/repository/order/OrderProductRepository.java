package com.mb.demo.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.demo.entity.common.OrderProductEntity;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProductEntity, Long> {

}
