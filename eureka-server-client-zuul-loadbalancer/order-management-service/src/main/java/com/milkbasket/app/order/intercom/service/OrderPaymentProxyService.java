package com.milkbasket.app.order.intercom.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="analytics-management-service")
public interface OrderPaymentProxyService {
  @GetMapping("/api/v1/order/status/1")
  public ResponseEntity<?> callPaymentService();
}

