package com.liqiang.pumpkin.boot.controller;

import com.liqiang.pumpkin.boot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@Slf4j
public class UserController {

  private static final String PAYMANT_URL = "http://localhost:8001";
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/{id}")
  public ResponseEntity findById(@PathVariable Long id) {
    log.info("1234");
    User findOne = restTemplate.getForObject(PAYMANT_URL + "/" + id, User.class);
    return ResponseEntity.ok(findOne);
  }

  @GetMapping("/create")
  public User create() {
    User user = User.builder().username("1234").name("123").age(18).balance(new BigDecimal("60.2")).build();
    return restTemplate.postForObject(PAYMANT_URL + "/create", user, User.class);
  }
}
