package com.liqiang.pumpkin.boot.controller;

import com.liqiang.pumpkin.boot.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFeignController {

  @Autowired
  private PaymentFeignService paymentFeignService;

  @GetMapping("/abc/abc")
  public String findById() {
    return paymentFeignService.findById2();
  }

  @GetMapping("/{id}")
  public ResponseEntity findById(@PathVariable Long id) {
    return ResponseEntity.ok(paymentFeignService.findById(id));
  }

  @GetMapping("/timeout/{id}")
  public ResponseEntity timeoutById(@PathVariable Long id) {
    // openfeign 默认等待1s钟
    return ResponseEntity.ok(paymentFeignService.timeoutById(id));
  }

}
