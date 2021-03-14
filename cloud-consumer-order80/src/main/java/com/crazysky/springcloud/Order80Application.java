package com.crazysky.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 订单服务80启动类
 * @author CrazySky
 * @date 2021/03/01 13:05
 */
@SpringBootApplication
@EnableEurekaClient
public class Order80Application {

    public static void main(String[] args) {
        SpringApplication.run(Order80Application.class, args);
    }
}
