package com.liqiang.pumpkin.boot.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
  @GetMapping("/abc/abc")
  public String findById2();

  @GetMapping("/{id}")
  public Map<String, Object> findById(@PathVariable("id") Long id);

  @GetMapping("/timeout/{id}")
  public Map<String, Object> timeoutById(@PathVariable("id") Long id);

}
