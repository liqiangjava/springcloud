package com.liqiang.pumpkin.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Start {
  public static void main(String[] args) {
    SpringApplication.run(Start.class, args);
  }
}
