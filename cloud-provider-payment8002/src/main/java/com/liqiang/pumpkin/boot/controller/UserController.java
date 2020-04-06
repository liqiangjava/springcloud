package com.liqiang.pumpkin.boot.controller;

import com.liqiang.pumpkin.boot.dao.UserRepository;
import com.liqiang.pumpkin.boot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Value("${server.port}")
  private String serverPort;

  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/{id}")
  public Map<String, Object> findById(@PathVariable Long id) {
    User findOne = userRepository.getOne(id);
    Map<String, Object> map = new HashMap<>();
    map.put("user", findOne);
    map.put("port", serverPort);
    List<String> services = discoveryClient.getServices();
    for (String str : services) {
      log.info("elements:{}", str);
    }
    map.put("services", services);
    List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    for (ServiceInstance serviceInstance : serviceInstances) {
      log.info("serviceId:{},host:{},port:{},uri:{}", serviceInstance.getServiceId(), serviceInstance.getHost(),
          serviceInstance.getPort(), serviceInstance.getUri());
    }
    map.put("serviceInstances", serviceInstances);
    return map;
  }

  @GetMapping("/abc/abc")
  public String findById2() {
    return "2222";
  }

  @PostMapping("/create")
  public User create(@RequestBody User user) {

    return userRepository.save(user);
  }
}
