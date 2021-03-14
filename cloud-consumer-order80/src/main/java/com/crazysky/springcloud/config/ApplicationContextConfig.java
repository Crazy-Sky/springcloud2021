package com.crazysky.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 应用上下文配置类
 * @author CrazySky
 * @date 2021/03/01 13:15
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 将RestTemplate注入到Spring容器
     * @author CrazySky
     * @date 2021/03/01 13:16
     * @return org.springframework.web.client.RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
