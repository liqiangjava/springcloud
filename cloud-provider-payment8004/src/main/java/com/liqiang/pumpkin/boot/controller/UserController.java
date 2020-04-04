package com.liqiang.pumpkin.boot.controller;

import com.liqiang.pumpkin.boot.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Value("${server.port}")
  private String serverPort;

  @GetMapping("/payment/zk")
  public ResponseEntity findById() {
    return ResponseEntity.ok(serverPort);
  }
}
