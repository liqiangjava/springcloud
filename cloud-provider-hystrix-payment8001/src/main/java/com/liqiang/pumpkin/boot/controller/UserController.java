package com.liqiang.pumpkin.boot.controller;

import com.liqiang.pumpkin.boot.dao.UserRepository;
import com.liqiang.pumpkin.boot.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Value("${server.port}")
  private String serverPort;

  /**
   * 正常访问，一定成功的
   * 
   * @param id
   * @return
   */
  public String paymentInfo_Ok(Integer id) {
    return "线程池:" + Thread.currentThread().getName() + "  paymentInfo_OK,id:" + id;
  }

  /**
   * <p>
   * 程序运行异常 超时 服务熔断触发服务降级 线程池/信号量打满也会导致服务
   *
   * </p>
   */
  public String paymentInfo_TimeOut(Integer id) {
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "线程池:" + Thread.currentThread().getName() + "  paymentInfo_timeout,id:" + id;
  }

  @GetMapping("/{id}")
  public Map<String, Object> findById(@PathVariable Long id) {
    // User findOne = userRepository.getOne(id);
    Map<String, Object> map = new HashMap<>();
    // map.put("user", findOne);
    // map.put("port", serverPort);
    String str = paymentInfo_Ok(id.intValue());
    map.put("str", str);
    log.info(str);
    return map;
  }

  @GetMapping("/timeout/{id}")
  @HystrixCommand(fallbackMethod = "paymentInfo_timeouthander", commandProperties = {
      // 异常，超时都会都会进到里面
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") })
  public Map<String, Object> timeoutById(@PathVariable Long id) {
    // try {
    // TimeUnit.SECONDS.sleep(3);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // User findOne = userRepository.getOne(id);
    Map<String, Object> map = new HashMap<>();
    // map.put("user", findOne);
    // map.put("port", serverPort);
    //int age = 10 / 0;
    String str = paymentInfo_TimeOut(id.intValue());
    map.put("str", str);
    log.info(str);
    return map;
  }

  public Map<String, Object> paymentInfo_timeouthander(Long id) {
    Map<String, Object> map = new HashMap<>();

    String str = "线程池报错:" + Thread.currentThread().getName() + "  paymentInfo_timeouthander,id:" + id;
    map.put("str", str);
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
