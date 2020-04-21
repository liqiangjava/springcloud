package com.liqiang.pumpkin.boot.controller.dao;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class GreetingsListener {
  /**
   *
   * @param greetings
   * @param partition 从哪个分区获取的数据
   */
  @StreamListener(GreetingsStreams.INPUT)
  public void handleGreetings(@Payload String greetings, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
    System.err.println("Received message: {" + greetings + "},from partition : {" + partition + "}");
  }
}