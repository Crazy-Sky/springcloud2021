package com.crazysky.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 支付服务8002启动类
 * @author CrazySky
 * @date 2021/03/01 13:06
 */
@SpringBootApplication
@EnableEurekaClient
public class Payment8002Application {

    public static void main(String[] args) {
        SpringApplication.run(Payment8002Application.class, args);
    }
}
