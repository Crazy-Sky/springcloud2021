package com.crazysky.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka 7001注册中心服务启动类
 * @author CrazySky
 * @date 2021/03/14 15:14
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka7001Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka7001Application.class, args);
    }
}
