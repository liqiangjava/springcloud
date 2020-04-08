package com.liqiang.pumpkin.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //启动断路器
public class Start {

  public static void main(String[] args) {
    SpringApplication.run(Start.class, args);
  }
}
