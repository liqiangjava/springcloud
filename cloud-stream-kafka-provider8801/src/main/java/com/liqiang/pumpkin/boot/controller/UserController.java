package com.liqiang.pumpkin.boot.controller;

import com.liqiang.pumpkin.boot.dao.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired
  private GreetingsService greetingsService;

  @RequestMapping("/send/{msg}")
  public void send(@PathVariable("msg") String msg) {
    greetingsService.sendGreeting(msg);
  }
}
