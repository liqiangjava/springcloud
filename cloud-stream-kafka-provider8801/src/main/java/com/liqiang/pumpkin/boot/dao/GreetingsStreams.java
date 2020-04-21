package com.liqiang.pumpkin.boot.dao;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface GreetingsStreams {
  String OUTPUT = "goods-out"; // 与配置中一样

  @Output(OUTPUT)
  MessageChannel outboundGreetings();
}