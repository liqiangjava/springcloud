package com.liqiang.pumpkin.boot.service;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
public class PaymentFallbackService implements PaymentHystrixService {

  @Override
  public Map<String, Object> findById(Long id) {
    return Collections.singletonMap("aaaa", "aaaa");
  }

  @Override
  public Map<String, Object> timeoutById(Long id) {
    return Collections.singletonMap("bbbb", "bbbbb");
  }
}
