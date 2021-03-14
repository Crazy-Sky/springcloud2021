package com.crazysky.springcloud.controller;

import com.crazysky.springcloud.entities.CommonResult;
import com.crazysky.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 订单服务访问控制类
 * @author CrazySky
 * @date 2021/03/01 13:11
 */
@RestController
@Slf4j
public class OrderController {

    // 单机版 private static final String PAYMENT_URL = "http://localhost:8001";
    // 负载均衡，多服务版
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 增加支付信息
     * @author CrazySky
     * @date 2021/03/01 13:25
     * @param payment 支付信息
     * @return com.crazysky.springcloud.entities.CommonResult<com.crazysky.springcloud.entities.Payment>
     */
    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Integer> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    /**
     * 根据id获取支付信息
     * @author CrazySky
     * @date 2021/03/01 14:13
     * @param id 支付信息编号
     * @return com.crazysky.springcloud.entities.CommonResult<com.crazysky.springcloud.entities.Payment>
     */
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
