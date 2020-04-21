package com.liqiang.pumpkin.boot.controller.dao;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface GreetingsStreams {
    String INPUT = "goods-in";
    @Input(INPUT)
    SubscribableChannel inboundGreetings();
}