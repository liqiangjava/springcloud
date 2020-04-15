package com.liqiang.pumpkin.boot;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableHystrixDashboard
public class Start {

  public static void main(String[] args) {
    SpringApplication.run(Start.class, args);
  }

  // 为了服务监控需配置，与服务容错本身无关
  @Bean
  public ServletRegistrationBean getServlet() {

    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
    registrationBean.setLoadOnStartup(1); // 系统启动时加载顺序
    registrationBean.addUrlMappings("/hystrix.stream");// 路径
    registrationBean.setName("HystrixMetricsStreamServlet");
    return registrationBean;
  }

}