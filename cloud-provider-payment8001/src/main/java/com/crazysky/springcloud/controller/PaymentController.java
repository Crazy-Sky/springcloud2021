package com.crazysky.springcloud.controller;

import com.crazysky.springcloud.entities.CommonResult;
import com.crazysky.springcloud.entities.Payment;
import com.crazysky.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 支付服务访问控制类
 * @author CrazySky
 * @date 2021/02/28 01:03
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 增加支付信息
     * @author CrazySky
     * @date 2021/03/01 14:13
     * @param payment 支付信息
     * @return com.crazysky.springcloud.entities.CommonResult<java.lang.Integer>
     */
    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        Integer result = paymentService.create(payment);
        log.info("插入结果----------------{}", result);
        if (result > 0) {
            return new CommonResult<>(200, "插入成功，serverPort：" + serverPort, result);
        }
        return new CommonResult(444, "插入失败");
    }

    /**
     * 根据id获取支付信息
     * @author CrazySky
     * @date 2021/03/01 14:14
     * @param id 支付信息编号
     * @return com.crazysky.springcloud.entities.CommonResult<com.crazysky.springcloud.entities.Payment>
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果----------------{}", payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功，serverPort：" + serverPort, payment);
        }
        return new CommonResult(444, "查询失败");
    }

    /**
     * 查询注册中心注册服务信息
     * @author CrazySky
     * @date 2021/03/17 18:58
     * @return com.crazysky.springcloud.entities.CommonResult<java.util.List<java.lang.String>>
     */
    @GetMapping(value = "/payment/discovery/services")
    public CommonResult<List<String>> discoveryServices() {
        List<String> services = discoveryClient.getServices();
        log.info("查询注册中心注册服务信息结果----------------{}", services);
        if (services != null) {
            return new CommonResult<>(200, "查询注册中心注册服务信息成功，serverPort：" + serverPort, services);
        }
        return new CommonResult(444, "查询注册中心注册服务信息失败");
    }

    /**
     * 查询注册中心注册服务的实例信息
     * @author CrazySky
     * @date 2021/03/17 18:55
     * @return com.crazysky.springcloud.entities.CommonResult
     */
    @GetMapping(value = "/payment/discovery/instances/{service}")
    public CommonResult<List<ServiceInstance>> discoveryInstances(@PathVariable("service") String service) {
        List<ServiceInstance> instances = discoveryClient.getInstances(service);
        log.info("查询注册中心注册服务的实例信息结果----------------{}", instances);
        if (instances != null) {
            return new CommonResult<>(200, "查询注册中心注册服务的实例信息成功，serverPort：" + serverPort, instances);
        }
        return new CommonResult(444, "查询注册中心注册服务的实例信息失败");
    }
}
