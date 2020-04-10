package com.liqiang.pumpkin.boot.controller;

import com.liqiang.pumpkin.boot.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentTimeoutFallbackMethod")
public class PaymentController {

  @Autowired
  private PaymentHystrixService paymentHystrixService;

  @GetMapping("/{id}")
  public Map<String, Object> findById(@PathVariable Long id) {
    return paymentHystrixService.findById(id);
  }

  @GetMapping("/timeout/{id}")
  // @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod", commandProperties = {
  // // 异常，超时都会都会进到里面
  // @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500") })
  public Map<String, Object> timeoutById(@PathVariable Long id) {
    return paymentHystrixService.timeoutById(id);
  }

  public Map<String, Object> paymentTimeoutFallbackMethod(Long id) {
    return Collections.singletonMap("a", id);
  }

}
