package com.crazysky.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 支付服务启动类
 * @author CrazySky
 * @date 2021/03/01 13:06
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }
}
